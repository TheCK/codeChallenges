package org.ck.adventofcode.year2022.day16;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20221601,
    name = "Day 16: Proboscidea Volcanium",
    url = "https://adventofcode.com/2022/day/16",
    category = "2022")
public class Part1 {
  private static final Pattern PATTERN =
      Pattern.compile("Valve ([A-Z]+) has flow rate=(\\d+); tunnels? leads? to valves? (.*)");

  private static Map<Status, Integer> cache;

  public static void main(String[] args) {
    cache = new HashMap<>();

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

    Status status = new Status("AA");
    int pressure = calculateMax(status, valves);

    System.out.println(pressure);
  }

  private static int calculateMax(final Status status, final Map<String, Valve> valves) {
    if (cache.containsKey(status)) {
      return cache.get(status);
    }

    if (status.getTimeLeft() == 0) {
      return 0;
    }

    int pressure = 0;
    int ticPressure = calculateTic(valves, status.getActiveValves());

    if (valves.get(status.getPosition()).capacity() > 0
        && !status.activeValves.contains(status.getPosition())) {
      pressure = calculateMax(Status.open(status), valves);
    }

    for (String neighbour : valves.get(status.getPosition()).tunnels) {
      pressure = Math.max(pressure, calculateMax(Status.move(status, neighbour), valves));
    }

    cache.put(status, pressure + ticPressure);
    return pressure + ticPressure;
  }

  private static int calculateTic(final Map<String, Valve> valves, final Set<String> activeValves) {
    int pressure = 0;

    for (String valve : activeValves) {
      pressure += valves.get(valve).capacity();
    }

    return pressure;
  }

  private static class Status {
    private String position;
    private int timeLeft = 30;
    private Set<String> activeValves = new HashSet<>();

    public Status(final String position) {
      this.position = position;
    }

    public static Status open(Status status) {
      Status newState = new Status(status.getPosition());
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves = new HashSet<>(status.getActiveValves());
      newState.activeValves.add(status.getPosition());

      return newState;
    }

    public static Status move(Status status, String newPosition) {
      Status newState = new Status(newPosition);
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves = new HashSet<>(status.getActiveValves());

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

    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Status status = (Status) o;
      return timeLeft == status.timeLeft
          && position.equals(status.position)
          && activeValves.equals(status.activeValves);
    }

    @Override
    public int hashCode() {
      return Objects.hash(position, timeLeft, activeValves);
    }
  }

  record Valve(int capacity, List<String> tunnels) {}
}
