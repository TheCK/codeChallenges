package org.ck.adventofcode.year2022.day16;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20221602,
    name = "Day 16: Proboscidea Volcanium - Part 2",
    url = "https://adventofcode.com/2022/day/16#part2",
    category = "2022")
public class Part2 {
  private static final Pattern PATTERN =
      Pattern.compile("Valve ([A-Z]+) has flow rate=(\\d+); tunnels? leads? to valves? (.*)");

  public static void main(String[] args) {
    Map<String, Valve> valves;
    try (Scanner in = new Scanner(System.in)) {
      valves = new HashMap<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
          valves.put(
              matcher.group(1),
              new Valve(Integer.parseInt(matcher.group(2)), List.of(matcher.group(3).split(", "))));
        }
      }
    }

    Map<String, Map<String, Integer>> distances = new HashMap<>();
    for (Map.Entry<String, Valve> start : valves.entrySet()) {
      if (start.getValue().capacity() > 0 || "AA".equals(start.getKey()))
        for (Map.Entry<String, Valve> end : valves.entrySet()) {
          if (end.getValue().capacity() > 0) {
            if (start.getKey().equals(end.getKey())) {
              continue;
            }

            if (!distances.containsKey(start.getKey())
                || !distances.get(start.getKey()).containsKey(end.getKey())) {
              Queue<SearchNode> queue = new ArrayDeque<>();
              queue.add(new SearchNode(start.getKey(), 0));

              while (!queue.isEmpty()) {
                SearchNode next = queue.poll();

                if (next.valve().equals(end.getKey())) {
                  distances.computeIfAbsent(start.getKey(), x -> new HashMap<>());
                  distances.computeIfAbsent(end.getKey(), x -> new HashMap<>());

                  distances.get(start.getKey()).put(end.getKey(), next.distance());
                  distances.get(end.getKey()).put(start.getKey(), next.distance());
                  break;
                }

                for (String neighbours : valves.get(next.valve()).tunnels()) {
                  queue.add(new SearchNode(neighbours, next.distance() + 1));
                }
              }
            }
          }
        }
    }

    List<String> valvesWithCapacity =
        valves.entrySet().stream()
            .filter(valve -> valve.getValue().capacity() > 0)
            .map(Map.Entry::getKey)
            .toList();

    int maxPressure = 0;
    for (int i = 0; i < Math.pow(2, valvesWithCapacity.size()); ++i) {
      Set<String> myValves = new HashSet<>();
      Set<String> elephantValves = new HashSet<>();

      for (int pos = 0; pos < valvesWithCapacity.size(); ++pos) {
        if ((1 << pos & i) != 0) {
          myValves.add(valvesWithCapacity.get(pos));
        } else {
          elephantValves.add(valvesWithCapacity.get(pos));
        }
      }

      Status myStatus = new Status("AA", myValves);
      int myPressure = calculateMax(myStatus, valves, distances);
      Status elephantStatus = new Status("AA", elephantValves);
      int elephantPressure = calculateMax(elephantStatus, valves, distances);

      maxPressure = Math.max(maxPressure, myPressure + elephantPressure);
    }

    System.out.println(maxPressure);
  }

  private static int calculateMax(
      final Status status,
      final Map<String, Valve> valves,
      final Map<String, Map<String, Integer>> distances) {
    if (status.getTimeLeft() == 0) {
      return 0;
    }

    int pressure = 0;
    int ticPressure = calculateTic(valves, status.getActiveValves());

    for (String neighbour : status.getPossibleValves()) {
      if (!status.getPosition().equals(neighbour)
          && !status.getActiveValves().contains(neighbour)) {
        if (distances.get(status.getPosition()).get(neighbour) < status.getTimeLeft()) {
          pressure =
              Math.max(
                  pressure,
                  calculateMax(
                          Status.open(
                              Status.move(
                                  status,
                                  neighbour,
                                  distances.get(status.getPosition()).get(neighbour))),
                          valves,
                          distances)
                      + ((distances.get(status.getPosition()).get(neighbour) + 1) * ticPressure));
        } else {
          pressure = Math.max(pressure, ticPressure * status.getTimeLeft());
        }
      } else {
        pressure = Math.max(pressure, ticPressure * status.getTimeLeft());
      }
    }

    return pressure;
  }

  private static int calculateTic(final Map<String, Valve> valves, final Set<String> activeValves) {
    int pressure = 0;

    for (String valve : activeValves) {
      pressure += valves.get(valve).capacity();
    }

    return pressure;
  }

  private static class Status {
    private final String position;
    private int timeLeft = 26;
    private final Set<String> activeValves = new LinkedHashSet<>();
    private final Set<String> possibleValves;

    public Status(final String position, Set<String> possibleValves) {
      this.position = position;
      this.possibleValves = possibleValves;
    }

    public static Status open(Status status) {
      Status newState = new Status(status.getPosition(), status.possibleValves);
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves.addAll(status.getActiveValves());
      newState.activeValves.add(status.getPosition());

      return newState;
    }

    public static Status move(Status status, String next, int distance) {
      Status newState = new Status(next, status.possibleValves);
      newState.timeLeft = status.timeLeft - distance;
      newState.activeValves.addAll(status.getActiveValves());

      return newState;
    }

    public String getPosition() {
      return position;
    }

    public int getTimeLeft() {
      return timeLeft;
    }

    public Set<String> getActiveValves() {
      return activeValves;
    }

    public Set<String> getPossibleValves() {
      return possibleValves;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Status status = (Status) o;
      return timeLeft == status.timeLeft
          && position.equals(status.position)
          && activeValves.equals(status.activeValves)
          && possibleValves.equals(status.possibleValves);
    }

    @Override
    public int hashCode() {
      return Objects.hash(position, timeLeft, activeValves, possibleValves);
    }
  }

  record Valve(int capacity, List<String> tunnels) {}

  record SearchNode(String valve, int distance) {}
}
