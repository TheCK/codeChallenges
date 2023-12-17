package org.ck.adventofcode.year2023;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231701,
    name = "Day 17: Clumsy Crucible",
    url = "https://adventofcode.com/2023/day/17",
    category = "2023")
@Solution(
    id = 20231702,
    name = "Day 17: Clumsy Crucible - Part 2",
    url = "https://adventofcode.com/2023/day/17#part2",
    category = "2023")
public class Day17 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 1, 3);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 4, 10);
  }

  private void run(final Scanner in, final int minStraight, final int maxStraight) {
    final List<List<Integer>> map = getMap(in);

    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingLong(State::cost));
    queue.add(new State(0, new Condition(new Cell(0, 0), Direction.RIGHT, 0)));
    queue.add(new State(0, new Condition(new Cell(0, 0), Direction.DOWN, 0)));

    final Set<Condition> visited = new HashSet<>();
    final Cell goal = new Cell(map.size() - 1, map.getLast().size() - 1);

    while (!queue.isEmpty()) {
      final State current = queue.poll();
      final Cell cell = current.condition().cell();

      if (cell.equals(goal) && current.condition().stepsInDirection() >= minStraight) {
        print(current.cost());
        return;
      }

      if (visited.contains(current.condition())) {
        continue;
      }

      visited.add(current.condition());

      move(queue, current, minStraight, maxStraight, map);
    }
  }

  private static void move(
      final Queue<State> queue,
      final State current,
      final int minStraight,
      final int maxStraight,
      final List<List<Integer>> map) {
    final Direction direction = current.condition().direction();
    final int stepsInCurrentDirection = current.condition().stepsInDirection();

    if (current.condition().stepsInDirection() < minStraight) {
      enqueueIfValid(queue, current, direction, map, stepsInCurrentDirection + 1);
    } else {
      for (Direction newDirection : Direction.values()) {
        if (canMoveIntoDirection(direction, stepsInCurrentDirection, newDirection, maxStraight)) {
          enqueueIfValid(
              queue,
              current,
              newDirection,
              map,
              newDirection == direction ? stepsInCurrentDirection + 1 : 1);
        }
      }
    }
  }

  private static List<List<Integer>> getMap(final Scanner in) {
    final List<List<Integer>> map = new ArrayList<>();

    while (in.hasNextLine()) {
      map.add(in.nextLine().chars().map(c -> c - '0').boxed().toList());
    }
    return map;
  }

  private static boolean canMoveIntoDirection(
      final Direction previousDirection,
      final int stepsInPreviousDirection,
      final Direction newDirection,
      final int maxStraight) {
    return (newDirection != previousDirection || stepsInPreviousDirection < maxStraight)
        && previousDirection != newDirection.reverse();
  }

  private static void enqueueIfValid(
      final Queue<State> queue,
      final State current,
      final Direction newDirection,
      final List<List<Integer>> map,
      final int newStepCount) {
    final int newRow = newDirection.getNewRow(current.condition().cell().row());
    final int newColumn = newDirection.getNewColumn(current.condition().cell().column());

    if (0 <= newRow
        && newRow < map.size()
        && 0 <= newColumn
        && newColumn < map.get(newRow).size()) {
      queue.add(
          new State(
              current.cost() + map.get(newRow).get(newColumn),
              new Condition(new Cell(newRow, newColumn), newDirection, newStepCount)));
    }
  }

  private record State(long cost, Condition condition) {}

  private record Condition(Cell cell, Direction direction, int stepsInDirection) {}

  private record Cell(int row, int column) {}

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public int getNewRow(int row) {
      return switch (this) {
        case LEFT -> row - 1;
        case RIGHT -> row + 1;
        default -> row;
      };
    }

    public int getNewColumn(int column) {
      return switch (this) {
        case UP -> column - 1;
        case DOWN -> column + 1;
        default -> column;
      };
    }

    public Direction reverse() {
      return switch (this) {
        case UP -> DOWN;
        case DOWN -> UP;
        case LEFT -> RIGHT;
        case RIGHT -> LEFT;
      };
    }
  }
}
