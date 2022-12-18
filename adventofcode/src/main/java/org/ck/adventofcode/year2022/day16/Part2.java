package org.ck.adventofcode.year2022.day16;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20221602,
    name = "Day 16: Proboscidea Volcanium - Part 2",
    url = "https://adventofcode.com/2022/day/16#part2",
    category = "2022",
    solved = false)
public class Part2 {
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

    Status status = new Status("AA", "AA");
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

    if (status.getPositionOne().equals(status.getPositionTwo())
        && valves.get(status.getPositionOne()).capacity() > 0
        && !status.getActiveValves().contains(status.getPositionOne())) {
      for (String neighbour : valves.get(status.getPositionTwo()).tunnels) {
        pressure =
            Math.max(pressure, calculateMax(Status.openOneAndMoveTwo(status, neighbour), valves));
      }
    }

    if (!status.getPositionOne().equals(status.getPositionTwo())
        && valves.get(status.getPositionOne()).capacity() > 0
        && valves.get(status.getPositionTwo()).capacity() > 0
        && !status.activeValves.contains(status.getPositionOne())
        && !status.activeValves.contains(status.getPositionTwo())) {
      pressure = Math.max(pressure, calculateMax(Status.openBoth(status), valves));
    }

    if (valves.get(status.getPositionOne()).capacity() > 0
        && !status.getActiveValves().contains(status.getPositionOne())) {
      for (String neighbour : valves.get(status.getPositionTwo()).tunnels) {
        pressure =
            Math.max(pressure, calculateMax(Status.openOneAndMoveTwo(status, neighbour), valves));
      }
    }

    if (valves.get(status.getPositionTwo()).capacity() > 0
        && !status.getActiveValves().contains(status.getPositionTwo())) {
      for (String neighbour : valves.get(status.getPositionOne()).tunnels) {
        pressure =
            Math.max(pressure, calculateMax(Status.openTwoAndMoveOne(status, neighbour), valves));
      }
    }

    for (String neighbourOne : valves.get(status.getPositionOne()).tunnels) {
      for (String neighbourTwo : valves.get(status.getPositionTwo()).tunnels) {
        pressure =
            Math.max(
                pressure,
                calculateMax(Status.moveBoth(status, neighbourOne, neighbourTwo), valves));
      }
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
    private final String positionOne;
    private final String positionTwo;
    private int timeLeft = 26;
    private Set<String> activeValves = new HashSet<>();

    public Status(final String positionOne, final String positionTwo) {
      this.positionOne = positionOne;
      this.positionTwo = positionTwo;
    }

    public static Status openBoth(Status status) {
      Status newState = new Status(status.getPositionOne(), status.getPositionTwo());
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves = new HashSet<>(status.getActiveValves());
      newState.activeValves.add(status.getPositionOne());
      newState.activeValves.add(status.getPositionTwo());

      return newState;
    }

    public static Status openOneAndMoveTwo(Status status, String newPosition) {
      Status newState = new Status(status.getPositionOne(), newPosition);
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves = new HashSet<>(status.getActiveValves());
      newState.activeValves.add(status.getPositionOne());

      return newState;
    }

    public static Status openTwoAndMoveOne(Status status, String newPosition) {
      Status newState = new Status(newPosition, status.getPositionTwo());
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves = new HashSet<>(status.getActiveValves());
      newState.activeValves.add(status.getPositionTwo());

      return newState;
    }

    public static Status moveBoth(Status status, String newPositionOne, String newPositionTwo) {
      Status newState = new Status(newPositionOne, newPositionTwo);
      newState.timeLeft = status.timeLeft - 1;
      newState.activeValves = new HashSet<>(status.getActiveValves());

      return newState;
    }

    public String getPositionOne() {
      return positionOne;
    }

    public String getPositionTwo() {
      return positionTwo;
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
          && (positionOne.equals(positionTwo)
              || Set.of(positionOne, positionTwo)
                  .equals(Set.of(status.positionOne, status.positionTwo)))
          && activeValves.equals(status.activeValves);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          positionOne.equals(positionTwo) ? positionOne : Set.of(positionOne, positionTwo),
          timeLeft,
          activeValves);
    }
  }

  record Valve(int capacity, List<String> tunnels) {}
}
