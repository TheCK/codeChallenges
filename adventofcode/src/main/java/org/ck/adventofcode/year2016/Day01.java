package org.ck.adventofcode.year2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160101,
    name = "Day 1: No Time for a Taxicab",
    url = "https://adventofcode.com/2016/day/1",
    category = "2016")
@Solution(
    id = 20160102,
    name = "Day 1: No Time for a Taxicab - Part 2",
    url = "https://adventofcode.com/2016/day/1#part2",
    category = "2016")
public class Day01 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (visited, current, solution) -> current);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (visited, current, solution) -> {
          if (solution != null) {
            return solution;
          }

          if (visited.contains(current)) {
            return current;
          }

          return null;
        });
  }

  private void run(final Scanner in, final TriFunction getSolution) {
    final String[] instructions = in.nextLine().split(", ");

    final Set<Point> visited = new HashSet<>();
    visited.add(new Point(0, 0));

    int x = 0;
    int y = 0;
    int direction = 0;

    Point solution = null;

    for (final String instruction : instructions) {
      direction += (instruction.charAt(0) == 'R' ? 1 : -1);

      if (direction == 4) {
        direction = 0;
      } else if (direction == -1) {
        direction = 3;
      }

      final int distance = Integer.parseInt(instruction.substring(1));

      for (int i = 0; i < distance; ++i) {
        switch (direction) {
          case 0 -> y -= 1;
          case 2 -> y += 1;
          case 1 -> x += 1;
          case 3 -> x -= 1;
          default -> throw new IllegalStateException("Unexpected value: " + direction);
        }

        final Point current = new Point(x, y);
        solution = getSolution.apply(visited, current, solution);

        visited.add(current);
      }
    }

    if (solution != null) {
      print(Math.abs(solution.x()) + Math.abs(solution.y()));
    }
  }

  record Point(int x, int y) {}

  private interface TriFunction {
    Point apply(final Set<Point> visited, final Point current, final Point solution);
  }
}
