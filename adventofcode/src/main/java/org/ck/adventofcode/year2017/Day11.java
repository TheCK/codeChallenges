package org.ck.adventofcode.year2017;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20171101,
    name = "Day 11: Hex Ed",
    url = "https://adventofcode.com/2017/day/11",
    category = "2017")
@Solution(
    id = 20171102,
    name = "Day 11: Hex Ed - Part 2",
    url = "https://adventofcode.com/2017/day/11#part2",
    category = "2017")
public class Day11 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (max, last) -> last);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (max, last) -> max);
  }

  private void run(final Scanner in, final IntBinaryOperator getResult) {
    final String[] directions = in.nextLine().split(",");
    Coordinate coordinate = new Coordinate(0, 0, 0);

    int max = 0;
    for (String direction : directions) {
      final Coordinate movement = getDifference(direction);
      coordinate =
          new Coordinate(
              coordinate.q() + movement.q(),
              coordinate.r() + movement.r(),
              coordinate.s() + movement.s());

      max = Math.max(max, getDistance(coordinate));
    }

    print(getResult.applyAsInt(max, getDistance(coordinate)));
  }

  private static int getDistance(final Coordinate coordinate) {
    return (Math.max(coordinate.q(), 0))
        + (Math.max(coordinate.r(), 0))
        + (Math.max(coordinate.s(), 0));
  }

  private Coordinate getDifference(final String direction) {
    return switch (direction) {
      case "n" -> new Coordinate(0, -1, 1);
      case "ne" -> new Coordinate(1, -1, 0);
      case "se" -> new Coordinate(1, 0, -1);
      case "s" -> new Coordinate(0, 1, -1);
      case "sw" -> new Coordinate(-1, 1, 0);
      case "nw" -> new Coordinate(-1, 0, 1);
      default -> throw new IllegalStateException("Unexpected value: " + direction);
    };
  }

  private record Coordinate(int q, int r, int s) {}
}
