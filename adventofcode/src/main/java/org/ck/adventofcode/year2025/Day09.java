package org.ck.adventofcode.year2025;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250901,
    name = "Day 9: Movie Theater",
    url = "https://adventofcode.com/2025/day/9",
    category = "2025")
@Solution(
    id = 20250902,
    name = "Day 9: Movie Theater - Part 2",
    url = "https://adventofcode.com/2025/day/9#part2",
    category = "2025")
public class Day09 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (_, _, _) -> true);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (current, other, lines) -> {
          final long minX = Math.min(current.x, other.x);
          final long maxX = Math.max(current.x, other.x);
          final long minY = Math.min(current.y, other.y);
          final long maxY = Math.max(current.y, other.y);

          final Line top =
              new Line(new Coordinate(minX + 1, minY + 1), new Coordinate(maxX - 1, minY + 1));
          final Line bottom =
              new Line(new Coordinate(minX + 1, maxY - 1), new Coordinate(maxX - 1, maxY - 1));
          if (lines.stream().anyMatch(top::intersects)
              || lines.stream().anyMatch(bottom::intersects)) {
            return false;
          }

          final Line left =
              new Line(new Coordinate(minX + 1, minY + 1), new Coordinate(minX + 1, maxY - 1));
          final Line right =
              new Line(new Coordinate(maxX - 1, minY + 1), new Coordinate(maxX - 1, maxY - 1));
          if (lines.stream().anyMatch(left::intersects)
              || lines.stream().anyMatch(right::intersects)) {
            return false;
          }

          return true;
        });
  }

  private void run(final Scanner in, final ValidityChecker validityChecker) {
    final List<Coordinate> tiles = new ArrayList<>();

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(",");
      tiles.add(new Coordinate(Long.parseLong(line[0]), Long.parseLong(line[1])));
    }

    final List<Line> lines = new ArrayList<>();
    for (int i = 0; i < tiles.size(); i++) {
      lines.add(new Line(tiles.get(i), tiles.get((i + 1) % tiles.size())));
    }

    long maxArea = 0;
    for (final Coordinate current : tiles) {
      for (final Coordinate other : tiles) {
        final long area = (1 + Math.abs(other.x - current.x)) * (1 + Math.abs(other.y - current.y));
        if (area > maxArea && validityChecker.apply(current, other, lines)) {
          maxArea = area;
        }
      }
    }

    print(maxArea);
  }

  private interface ValidityChecker {
    boolean apply(Coordinate tile1, Coordinate tile2, final List<Line> lines);
  }

  private record Coordinate(long x, long y) {}

  private record Line(Coordinate start, Coordinate end) {
    public boolean intersects(final Line other) {
      final boolean thisIsVertical = start.x == end.x;
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (thisIsVertical && otherIsVertical || !thisIsVertical && !otherIsVertical) {
        return false;
      }

      if (thisIsVertical) {
        return Math.min(other.start.x, other.end.x) < start.x
            && start.x < Math.max(other.start.x, other.end.x)
            && Math.min(start.y, end.y) <= other.start.y
            && other.start.y < Math.max(start.y, end.y);
      }

      return Math.min(start.x, end.x) <= other.start.x
          && other.start.x <= Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) <= start.y
          && start.y <= Math.max(other.start.y, other.end.y);
    }
  }
}
