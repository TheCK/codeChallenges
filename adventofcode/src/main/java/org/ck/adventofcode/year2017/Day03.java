package org.ck.adventofcode.year2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170301,
    name = "Day 3: Spiral Memory",
    url = "https://adventofcode.com/2017/day/3",
    category = "2017")
@Solution(
    id = 20170302,
    name = "Day 3: Spiral Memory - Part 2",
    url = "https://adventofcode.com/2017/day/3#part2",
    category = "2017")
public class Day03 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (cell, x, y, memory) -> cell,
        (maxCell, cell, newValue) -> cell > maxCell,
        (x, y, memory) -> Math.abs(x) + Math.abs(y));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (cell, x, y, memory) -> getValue(memory, x, y),
        (maxCell, cell, newValue) -> newValue > maxCell,
        (x, y, memory) -> memory.get(new Coordinates(x, y)));
  }

  private void run(
      final Scanner in,
      final GetCellValue getCellValue,
      final GetBreakCondition getBreakCondition,
      final GetOutput getOutput) {
    final Map<Coordinates, Long> memory = new HashMap<>();

    final long maxCell = in.nextLong();

    int x = 0;
    int y = 0;

    Direction direction = Direction.RIGHT;

    int cell = 2;
    memory.put(new Coordinates(x, y), 1L);
    while (true) {
      if (getBreakCondition.get(maxCell, cell, 0)) {
        break;
      }

      x += direction.getdX();
      y += direction.getdY();

      final long newValue = getCellValue.get(cell, x, y, memory);
      memory.put(new Coordinates(x, y), newValue);

      if (getBreakCondition.get(maxCell, cell, newValue)) {
        break;
      }

      if (!memory.containsKey(
          new Coordinates(x + direction.getNext().getdX(), y + direction.getNext().getdY()))) {
        direction = direction.getNext();
      }

      ++cell;
    }

    print(getOutput.get(x, y, memory));
  }

  private static Long getValue(final Map<Coordinates, Long> memory, final int x, final int y) {
    return memory.getOrDefault(new Coordinates(x - 1, y - 1), 0L)
        + memory.getOrDefault(new Coordinates(x - 1, y), 0L)
        + memory.getOrDefault(new Coordinates(x - 1, y + 1), 0L)
        + memory.getOrDefault(new Coordinates(x, y - 1), 0L)
        + memory.getOrDefault(new Coordinates(x, y + 1), 0L)
        + memory.getOrDefault(new Coordinates(x + 1, y - 1), 0L)
        + memory.getOrDefault(new Coordinates(x + 1, y), 0L)
        + memory.getOrDefault(new Coordinates(x + 1, y + 1), 0L);
  }

  private record Coordinates(int x, int y) {}

  private enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    RIGHT(1, 0),
    LEFT(-1, 0);

    private final int dX;
    private final int dY;

    Direction(final int dX, final int dY) {
      this.dX = dX;
      this.dY = dY;
    }

    public int getdX() {
      return dX;
    }

    public int getdY() {
      return dY;
    }

    public Direction getNext() {
      return switch (this) {
        case UP -> LEFT;
        case DOWN -> RIGHT;
        case RIGHT -> UP;
        case LEFT -> DOWN;
      };
    }
  }

  private interface GetCellValue {
    long get(final long cell, final int x, final int y, final Map<Coordinates, Long> memory);
  }

  private interface GetBreakCondition {
    boolean get(final long maxCell, final long cell, final long newValue);
  }

  private interface GetOutput {
    long get(final int x, final int y, final Map<Coordinates, Long> memory);
  }
}
