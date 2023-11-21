package org.ck.adventofcode.year2017.day03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170302,
    name = "Day 3: Spiral Memory - Part 2",
    url = "https://adventofcode.com/2017/day/3#part2",
    category = "2017")
public class Part2 {
  public static void main(String[] args) {
    final Map<Coordinates, Long> memory = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      final long maxCell = in.nextInt();

      int x = 0;
      int y = 0;

      Direction direction = Direction.RIGHT;

      memory.put(new Coordinates(x, y), 1L);
      while (true) {
        x += direction.getdX();
        y += direction.getdY();

        Long newValue = getValue(memory, x, y);
        memory.put(new Coordinates(x, y), newValue);

        if (newValue > maxCell) {
          break;
        }

        if (!memory.containsKey(
            new Coordinates(x + direction.getNext().getdX(), y + direction.getNext().getdY()))) {
          direction = direction.getNext();
        }
      }

      System.out.println(memory.get(new Coordinates(x, y)));
    }
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
}
