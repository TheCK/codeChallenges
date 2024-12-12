package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.ToLongFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241201,
    name = "Day 12: Garden Groups",
    url = "https://adventofcode.com/2024/day/12",
    category = "2024")
@Solution(
    id = 20241202,
    name = "Day 12: Garden Groups - Part 2",
    url = "https://adventofcode.com/2024/day/12#part2",
    category = "2024")
public class Day12 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day12::getPerimeter);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day12::getSides);
  }

  private void run(final Scanner in, final ToLongFunction<Set<Coordinate>> getFences) {
    final Map<Coordinate, Region> plotToRegion = new HashMap<>();

    int y = 0;
    while (in.hasNextLine()) {
      final String line = in.nextLine();

      for (int x = 0; x < line.length(); ++x) {
        final Coordinate coordinate = new Coordinate(x, y);
        final char name = line.charAt(x);

        final Coordinate leftPlot = new Coordinate(x - 1, y);
        final Coordinate abovePlot = new Coordinate(x, y - 1);

        Region leftRegion = null;
        Region aboveRegion = null;
        if (plotToRegion.containsKey(leftPlot) && plotToRegion.get(leftPlot).name() == name) {
          leftRegion = plotToRegion.get(leftPlot);
        }
        if (plotToRegion.containsKey(abovePlot) && plotToRegion.get(abovePlot).name() == name) {
          aboveRegion = plotToRegion.get(abovePlot);
        }

        final Region region;
        if (leftRegion != null && aboveRegion != null && !leftRegion.equals(aboveRegion)) {
          region = aboveRegion;
          for (Coordinate plot : leftRegion.plots()) {
            plotToRegion.put(plot, region);
          }
          aboveRegion.plots().addAll(leftRegion.plots());
        } else if (leftRegion != null) {
          region = leftRegion;
        } else if (aboveRegion != null) {
          region = aboveRegion;
        } else {
          region = new Region(line.charAt(x), new HashSet<>());
        }

        region.plots().add(coordinate);
        plotToRegion.put(coordinate, region);
      }

      ++y;
    }

    print(getPrice(new HashSet<>(plotToRegion.values()), getFences));
  }

  private static long getPrice(
      final Set<Region> regions, final ToLongFunction<Set<Coordinate>> getFences) {
    long price = 0L;

    for (final Region region : regions) {
      price += getPrice(region, getFences);
    }

    return price;
  }

  private static long getPrice(
      final Region region, final ToLongFunction<Set<Coordinate>> getFences) {
    final long size = region.plots().size();
    final long fences = getFences.applyAsLong(region.plots());

    System.err.println(
        "A region of %c plants with price %d * %d = %d"
            .formatted(region.name(), size, fences, size * fences));
    return size * fences;
  }

  private static long getPerimeter(final Set<Coordinate> coordinates) {
    long perimiter = 0L;

    for (final Coordinate coordinate : coordinates) {
      for (final Coordinate direction :
          List.of(
              new Coordinate(coordinate.x() - 1, coordinate.y()),
              new Coordinate(coordinate.x() + 1, coordinate.y()),
              new Coordinate(coordinate.x(), coordinate.y() - 1),
              new Coordinate(coordinate.x(), coordinate.y() + 1))) {
        if (!coordinates.contains(direction)) {
          ++perimiter;
        }
      }
    }

    return perimiter;
  }

  private static long getSides(final Set<Coordinate> coordinates) {
    long sides = 0L;

    for (final Coordinate coordinate : coordinates) {
      final Coordinate left = new Coordinate(coordinate.x() - 1, coordinate.y());
      final Coordinate right = new Coordinate(coordinate.x() + 1, coordinate.y());
      final Coordinate above = new Coordinate(coordinate.x(), coordinate.y() - 1);
      final Coordinate below = new Coordinate(coordinate.x(), coordinate.y() + 1);

      final Coordinate aboveLeft = new Coordinate(coordinate.x() - 1, coordinate.y() - 1);
      final Coordinate aboveRight = new Coordinate(coordinate.x() + 1, coordinate.y() - 1);
      final Coordinate belowLeft = new Coordinate(coordinate.x() - 1, coordinate.y() + 1);
      final Coordinate belowRight = new Coordinate(coordinate.x() + 1, coordinate.y() + 1);

      if (isOuterCorner(coordinates, left, above)) {
        ++sides;
      }
      if (isOuterCorner(coordinates, above, right)) {
        ++sides;
      }
      if (isOuterCorner(coordinates, left, below)) {
        ++sides;
      }
      if (isOuterCorner(coordinates, below, right)) {
        ++sides;
      }
      if (isInnerCorner(coordinates, above, left, aboveLeft)) {
        ++sides;
      }
      if (isInnerCorner(coordinates, above, right, aboveRight)) {
        ++sides;
      }
      if (isInnerCorner(coordinates, below, left, belowLeft)) {
        ++sides;
      }
      if (isInnerCorner(coordinates, below, right, belowRight)) {
        ++sides;
      }
    }

    return sides;
  }

  private static boolean isInnerCorner(
      final Set<Coordinate> coordinates,
      final Coordinate one,
      final Coordinate two,
      final Coordinate oneTwo) {
    return coordinates.contains(one) && coordinates.contains(two) && !coordinates.contains(oneTwo);
  }

  private static boolean isOuterCorner(
      final Set<Coordinate> coordinates, final Coordinate one, final Coordinate two) {
    return !coordinates.contains(one) && !coordinates.contains(two);
  }

  private record Coordinate(int x, int y) {}

  private record Region(char name, Set<Coordinate> plots) {}
}
