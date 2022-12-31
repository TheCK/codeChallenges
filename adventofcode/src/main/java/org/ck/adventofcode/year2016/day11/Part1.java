package org.ck.adventofcode.year2016.day11;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161101,
    name = "Day 11: Radioisotope Thermoelectric Generators",
    url = "https://adventofcode.com/2016/day/11",
    category = "2016",
    solved = false)
public class Part1 {
  private static final Pattern pattern =
      Pattern.compile("([a-z]+)(-compatible)? (microchip|generator)");

  public static void main(String[] args) {
    List<Set<String>> floors = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      int i = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();
        floors.add(new HashSet<>());

        Matcher matcher = pattern.matcher(line);

        int start = 0;
        while (matcher.find(start)) {
          String key =
              ""
                  + matcher.group(1).toUpperCase().charAt(0)
                  + matcher.group(3).toUpperCase().charAt(0);

          floors.get(i).add(key);

          start = matcher.end();
        }

        ++i;
      }
    }

    Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::steps));
    queue.add(new State(floors, new Elevator(0, new HashSet<>()), 0));

    while (!queue.isEmpty()) {
      State state = queue.poll();
      List<Set<String>> currentFloors = state.floors();
      Elevator elevator = state.elevator();

      for (int i = 0; i < currentFloors.size(); ++i) {
        if (!isFloorValid(
            currentFloors.get(i), elevator.floor() == i ? elevator.items() : new HashSet<>())) {
          continue;
        }
      }

      if (currentFloors.get(0).isEmpty()
          && currentFloors.get(1).isEmpty()
          && currentFloors.get(2).isEmpty()
          && elevator.items().isEmpty()) {
        System.out.println(state.steps());
        return;
      }
    }
  }

  private static boolean isFloorValid(final Set<String> items, final Set<String> elevatorItems) {
    Set<String> toCheck = new HashSet<>(items);
    toCheck.addAll(elevatorItems);

    boolean containsGenerator = false;
    for (String item : toCheck) {
      String[] split = item.split("");

      if (split[1].equals("G")) {
        containsGenerator = true;
        break;
      }
    }

    if (containsGenerator) {
      for (String item : toCheck) {
        String[] split = item.split("");

        if (split[1].equals("M") && !toCheck.contains(split[0] + "G")) {
          return false;
        }
      }
    }

    return true;
  }

  record State(List<Set<String>> floors, Elevator elevator, int steps) {}

  record Elevator(int floor, Set<String> items) {}
}
