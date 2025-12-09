package org.ck.adventofcode.year2025;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250901,
    name = "Day 9: ",
    url = "https://adventofcode.com/2025/day/9",
    category = "2025",
    solved = false)
@Solution(
    id = 20250902,
    name = "Day 9:  - Part 2",
    url = "https://adventofcode.com/2025/day/9#part2",
    category = "2025",
    solved = false)
public class Day09 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (_, _, _) -> true);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (current, other, boundingLines) -> {
          final long minX = Math.min(current.x, other.x);
          final long maxX = Math.max(current.x, other.x);
          final long minY = Math.min(current.y, other.y);
          final long maxY = Math.max(current.y, other.y);

          final Line topLine = new Line(new Coordinate(minX, minY), new Coordinate(maxX, minY));
          final Line bottomLine = new Line(new Coordinate(minX, maxY), new Coordinate(maxX, maxY));
          final Line leftLine = new Line(new Coordinate(minX, minY), new Coordinate(minX, maxY));
          final Line rightLine = new Line(new Coordinate(maxX, minY), new Coordinate(maxX, maxY));

          return boundingLines.stream()
              .anyMatch(
                  line ->
                      topLine.intersectsTopLine(line)
                          || bottomLine.intersectsBottomLine(line)
                          || leftLine.intersectsLeftLine(line)
                          || rightLine.intersectsRightLine(line));

          /*
          final Coordinate topCorner =
              current.y < other.y
                  ? new Coordinate(other.x, current.y)
                  : new Coordinate(current.x, other.y);
          final Coordinate bottomCorner =
              current.y >= other.y
                  ? new Coordinate(other.x, current.y)
                  : new Coordinate(current.x, other.y);

          final boolean allPointsInside =
              isInsideBelow(topCorner, boundingLines) && isInsideAbove(bottomCorner, boundingLines);

          if (!allPointsInside) {
            return false;
          }

          return true;

          /*
          for (long x = Math.min(current.x, other.x) + 1; x < Math.max(current.x, other.x); ++x) {
            if (!isInside(new Coordinate(x, current.y), boundingLines)
                || !isInside(new Coordinate(x, other.y), boundingLines)) {
              return false;
            }
          }

          for (long y = Math.min(current.y, other.y) + 1; y < Math.max(current.y, other.y); ++y) {
            if (!isInside(new Coordinate(current.x, y), boundingLines)
                || !isInside(new Coordinate(other.x, y), boundingLines)) {
              return false;
            }
          }

          return true;

          /*final Set<Line> rectangle =
              Set.of(
                  new Line(current, corner1),
                  new Line(current, corner2),
                  new Line(other, corner1),
                  new Line(other, corner2));

          for (final Line side : rectangle) {
            for (final Line boundingLine : boundingLines) {
              if (side.reallyIntersects(boundingLine)) {
                return false;
              }
            }
          }

          return true;*/
        });
  }

  private void run(final Scanner in, final TriPredicate validityChecker) {
    final List<Coordinate> tiles = new ArrayList<>();
    long maxArea = 0;

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(",");
      tiles.add(new Coordinate(Long.parseLong(line[0]), Long.parseLong(line[1])));
    }

    final List<Line> lines = new ArrayList<>();
    for (int i = 0; i < tiles.size(); i++) {
      lines.add(new Line(tiles.get(i), tiles.get((i + 1) % tiles.size())));
    }

    for (int i = 0; i < tiles.size(); ++i) {
      final Coordinate current = tiles.get(i);

      for (int j = i + 1; j < tiles.size(); ++j) {
        final Coordinate other = tiles.get(j);

        final long area = (1 + Math.abs(other.x - current.x)) * (1 + Math.abs(other.y - current.y));
        if (area > maxArea && validityChecker.apply(current, other, lines)) {
          maxArea = area;
        }
      }
    }

    print(maxArea);
  }

  private boolean isInsideBelow(final Coordinate point, final List<Line> boundingLines) {
    final Line ray = new Line(point, new Coordinate(100000, point.y));

    return boundingLines.stream().filter(ray::intersectsRayBelow).count() % 2 == 1;
  }

  private boolean isInsideAbove(final Coordinate point, final List<Line> boundingLines) {
    final Line ray = new Line(point, new Coordinate(100000, point.y));

    return boundingLines.stream().filter(ray::intersectsRayAbove).count() % 2 == 1;
  }

  private interface TriPredicate {
    boolean apply(Coordinate tile1, Coordinate tile2, List<Line> lines);
  }

  private record Coordinate(long x, long y) {}

  private record Line(Coordinate start, Coordinate end) {
    public boolean intersectsTopLine(final Line other) {
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (!otherIsVertical) {
        return false;
      }

      return Math.min(start.x, end.x) < other.start.x
          && other.start.x < Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) <= start.y
          && start.y < Math.max(other.start.y, other.end.y);
    }

    public boolean intersectsBottomLine(final Line other) {
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (!otherIsVertical) {
        return false;
      }

      return Math.min(start.x, end.x) < other.start.x
          && other.start.x < Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) < start.y
          && start.y <= Math.max(other.start.y, other.end.y);
    }

    public boolean intersectsLeftLine(final Line other) {
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (otherIsVertical) {
        return false;
      }

      return Math.min(start.x, end.x) <= other.start.x
          && other.start.x < Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) < start.y
          && start.y < Math.max(other.start.y, other.end.y);
    }

    public boolean intersectsRightLine(final Line other) {
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (otherIsVertical) {
        return false;
      }

      return Math.min(start.x, end.x) < other.start.x
          && other.start.x <= Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) < start.y
          && start.y < Math.max(other.start.y, other.end.y);
    }

    public boolean intersectsRayBelow(final Line other) {
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (!otherIsVertical) {
        return false;
      }

      return Math.min(start.x, end.x) < other.start.x
          && other.start.x <= Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) <= start.y
          && start.y < Math.max(other.start.y, other.end.y);
    }

    public boolean intersectsRayAbove(final Line other) {
      final boolean otherIsVertical = other.start.x == other.end.x;

      if (!otherIsVertical) {
        return false;
      }

      return Math.min(start.x, end.x) < other.start.x
          && other.start.x <= Math.max(start.x, end.x)
          && Math.min(other.start.y, other.end.y) < start.y
          && start.y <= Math.max(other.start.y, other.end.y);
    }
  }
}
