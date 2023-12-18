package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231801,
    name = "Day 18: Lavaduct Lagoon",
    url = "https://adventofcode.com/2023/day/18",
    category = "2023")
@Solution(
    id = 20231802,
    name = "Day 18: Lavaduct Lagoon - Part 2",
    url = "https://adventofcode.com/2023/day/18#part2",
    category = "2023",
    solved = false)
public class Day18 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        parts ->
            new Command(
                switch (parts[0]) {
                  case "R" -> Direction.RIGHT;
                  case "L" -> Direction.LEFT;
                  case "U" -> Direction.UP;
                  case "D" -> Direction.DOWN;
                  default -> throw new IllegalArgumentException();
                },
                Long.parseLong(parts[1])));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        parts ->
            new Command(
                switch (parts[2].charAt(7)) {
                  case '0' -> Direction.RIGHT;
                  case '2' -> Direction.LEFT;
                  case '3' -> Direction.UP;
                  case '1' -> Direction.DOWN;
                  default -> throw new IllegalArgumentException();
                },
                Long.parseLong(parts[2].substring(2, 7), 16)));
  }

  private void run(final Scanner in, final Function<String[], Command> getCommand) {
    final Set<Dig> digs = new HashSet<>();
    digs.add(new Dig(0, 0));
    int row = 0;
    int column = 0;

    while (in.hasNextLine()) {
      final Command command = getCommand.apply(in.nextLine().split(" "));
      for (long i = 0; i < command.length(); ++i) {
        switch (command.direction()) {
          case RIGHT -> ++column;
          case LEFT -> --column;
          case UP -> --row;
          case DOWN -> ++row;
        }

        digs.add(new Dig(row, column));
      }
    }

    final int minRow = digs.stream().mapToInt(Dig::row).min().orElseThrow();
    final int minColumnOnSecondRow =
        digs.stream()
            .filter(dig -> dig.row() == minRow + 1)
            .mapToInt(Dig::column)
            .min()
            .orElseThrow();

    final Queue<Dig> queue = new ArrayDeque<>();
    queue.add(new Dig(minRow + 1, minColumnOnSecondRow + 1));

    while (!queue.isEmpty()) {
      final Dig current = queue.poll();
      if (digs.contains(current)) {
        continue;
      }

      digs.add(current);

      for (int dx = -1; dx <= 1; ++dx) {
        for (int dy = -1; dy <= 1; ++dy) {
          if ((dx + dy) % 2 != 0) {
            final Dig newDig = new Dig(current.row + dy, current.column + dx);

            if (!digs.contains(newDig)) {
              queue.add(newDig);
            }
          }
        }
      }
    }

    print(digs.size());
  }

  private record Command(Direction direction, long length) {}

  private record Dig(int row, int column) {}

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }
}
