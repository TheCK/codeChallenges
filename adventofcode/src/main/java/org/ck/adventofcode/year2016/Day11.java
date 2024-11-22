package org.ck.adventofcode.year2016;

import static java.util.stream.Collectors.toSet;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161101,
    name = "Day 11: Radioisotope Thermoelectric Generators",
    url = "https://adventofcode.com/2016/day/11",
    category = "2016")
@Solution(
    id = 20161102,
    name = "Day 11: Radioisotope Thermoelectric Generators - Part 2",
    url = "https://adventofcode.com/2016/day/11#part2",
    category = "2016")
public class Day11 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile("(?<element>[a-z]+)(-compatible)? (?<type>microchip|generator)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final List<Set<Item>> initialFloors = readInput(in);

    final Set<SimplifiedState> alreadySeen = new HashSet<>();

    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::steps));
    queue.add(new State(initialFloors, 0, 0));

    while (!queue.isEmpty()) {
      final State state = queue.poll();
      final SimplifiedState simplifiedState = SimplifiedState.of(state);

      if (alreadySeen.contains(simplifiedState)) {
        continue;
      }

      alreadySeen.add(simplifiedState);

      final List<Set<Item>> floors = state.floors();
      final int elevator = state.elevator();
      final int steps = state.steps();

      if (isFinalState(floors)) {
        print(state.steps());
        return;
      }

      moveElevatorDown(queue, floors, elevator, steps);
      moveElevatorUp(queue, floors, elevator, steps);
    }
  }

  private static boolean isFinalState(final List<Set<Item>> floors) {
    return floors.get(0).isEmpty() && floors.get(1).isEmpty() && floors.get(2).isEmpty();
  }

  private static void moveElevatorUp(
      final Queue<State> queue, final List<Set<Item>> floors, final int elevator, final int steps) {
    if (elevator < floors.size() - 1) {
      for (final Item firstItem : floors.get(elevator)) {
        final List<Set<Item>> newFloors = floors.stream().<Set<Item>>map(HashSet::new).toList();

        newFloors.get(elevator).remove(firstItem);
        newFloors.get(elevator + 1).add(firstItem);

        boolean anyValid = tryMovingSecondItemUp(queue, floors, elevator, steps, newFloors);

        if (isStateValid(newFloors) && !anyValid) {
          queue.add(new State(newFloors, elevator + 1, steps + 1));
        }
      }
    }
  }

  private static boolean tryMovingSecondItemUp(
      final Queue<State> queue,
      final List<Set<Item>> floors,
      final int elevator,
      final int steps,
      final List<Set<Item>> newFloors) {
    boolean anyValid = false;
    if (!floors.get(elevator).isEmpty()) {
      for (final Item secondItem : newFloors.get(elevator)) {
        final List<Set<Item>> newFloors2 = newFloors.stream().<Set<Item>>map(HashSet::new).toList();

        newFloors2.get(elevator).remove(secondItem);
        newFloors2.get(elevator + 1).add(secondItem);

        if (isStateValid(newFloors2)) {
          anyValid = true;
          queue.add(new State(newFloors2, elevator + 1, steps + 1));
        }
      }
    }
    return anyValid;
  }

  private static void moveElevatorDown(
      final Queue<State> queue, final List<Set<Item>> floors, final int elevator, final int steps) {
    if (elevator > 0 && floors.stream().limit(elevator).anyMatch(floor -> !floor.isEmpty())) {
      for (final Item item : floors.get(elevator)) {
        final List<Set<Item>> newFloors = floors.stream().<Set<Item>>map(HashSet::new).toList();

        newFloors.get(elevator).remove(item);
        newFloors.get(elevator - 1).add(item);

        if (isStateValid(newFloors)) {
          queue.add(new State(newFloors, elevator - 1, steps + 1));
        }
      }
    }
  }

  private static boolean isStateValid(final List<Set<Item>> floors) {
    for (int floor = 0; floor < floors.size(); ++floor) {
      if (!isFloorValid(floors.get(floor))) {
        return false;
      }
    }

    return true;
  }

  private static List<Set<Item>> readInput(final Scanner in) {
    final List<Set<Item>> floors = new ArrayList<>();

    int floor = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      floors.add(new HashSet<>());

      final Matcher matcher = PATTERN.matcher(line);

      int start = 0;
      while (matcher.find(start)) {
        floors
            .get(floor)
            .add(
                new Item(
                    matcher.group("element"), Type.valueOf(matcher.group("type").toUpperCase())));

        start = matcher.end();
      }

      ++floor;
    }
    return floors;
  }

  private static boolean isFloorValid(final Set<Item> items) {
    final Map<Type, Set<Item>> groups =
        items.stream().collect(Collectors.groupingBy(Item::type, toSet()));

    return !groups.containsKey(Type.GENERATOR)
        || !groups.containsKey(Type.MICROCHIP)
        || groups.get(Type.MICROCHIP).stream()
            .allMatch(
                chip ->
                    groups.get(Type.GENERATOR).contains(new Item(chip.element(), Type.GENERATOR)));
  }

  record SimplifiedState(List<Map<Type, Long>> floors, int elevator) {
    private static SimplifiedState of(final State state) {
      return new SimplifiedState(
          state.floors().stream()
              .map(
                  floor ->
                      floor.stream()
                          .collect(Collectors.groupingBy(Item::type, Collectors.counting())))
              .toList(),
          state.elevator());
    }
  }

  record State(List<Set<Item>> floors, int elevator, int steps) {}

  record Item(String element, Type type) {}

  private enum Type {
    MICROCHIP,
    GENERATOR;
  }
}
