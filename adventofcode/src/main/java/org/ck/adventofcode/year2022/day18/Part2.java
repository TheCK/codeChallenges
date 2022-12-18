package org.ck.adventofcode.year2022.day18;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Solution(
    id = 20221802,
    name = "Day 18: Boiling Boulders - Part 2",
    url = "https://adventofcode.com/2022/day/18#part2",
    category = "2022")
public class Part2 {
  private static boolean[][][] searched;

  public static void main(String[] args) {
    Set<Point> cubes = new HashSet<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] coords = in.nextLine().split(",");
        cubes.add(
            new Point(
                Integer.parseInt(coords[0]),
                Integer.parseInt(coords[1]),
                Integer.parseInt(coords[2])));
      }
    }

    IntSummaryStatistics xStats = cubes.stream().mapToInt(Point::x).summaryStatistics();
    IntSummaryStatistics yStats = cubes.stream().mapToInt(Point::y).summaryStatistics();
    IntSummaryStatistics zStats = cubes.stream().mapToInt(Point::z).summaryStatistics();

    searched = new boolean[xStats.getMax() + 1][yStats.getMax() + 1][zStats.getMax() + 1];

    Set<Point> inverse =
        getInverse(
            cubes,
            xStats.getMin(),
            xStats.getMax(),
            yStats.getMin(),
            yStats.getMax(),
            zStats.getMin(),
            zStats.getMax());

    Set<Point> outerShell =
        getOuterShell(
            inverse,
            xStats.getMin(),
            xStats.getMax(),
            yStats.getMin(),
            yStats.getMax(),
            zStats.getMin(),
            zStats.getMax());

    for (Point node : outerShell) {
      Deque<Point> stack = new ArrayDeque<>();
      stack.push(node);

      while (!stack.isEmpty()) {
        Point current = stack.pop();

        if (searched[current.x()][current.y()][current.z()]) {
          continue;
        }
        searched[current.x()][current.y()][current.z()] = true;

        for (Point next :
            Stream.of(
                    new Point(current.x() - 1, current.y(), current.z()),
                    new Point(current.x() + 1, current.y(), current.z()),
                    new Point(current.x(), current.y() - 1, current.z()),
                    new Point(current.x(), current.y() + 1, current.z()),
                    new Point(current.x(), current.y(), current.z() - 1),
                    new Point(current.x(), current.y(), current.z() + 1))
                .filter(inverse::contains)
                .toList()) {
          stack.push(next);
        }
      }
    }

    cubes.addAll(
        inverse.stream()
            .filter(point -> !searched[point.x()][point.y()][point.z()])
            .collect(Collectors.toSet()));

    int visible = 0;

    for (Point cube : cubes) {
      Set<Point> neighbours = getNeighbours(cubes, cube);
      visible += 6 - neighbours.size();
    }

    System.out.println(visible);
  }

  private static Set<Point> getNeighbours(final Set<Point> cubes, final Point cube) {
    Set<Point> neighbours = new HashSet<>(cubes);

    neighbours.retainAll(
        Set.of(
            new Point(cube.x() - 1, cube.y(), cube.z()),
            new Point(cube.x() + 1, cube.y(), cube.z()),
            new Point(cube.x(), cube.y() - 1, cube.z()),
            new Point(cube.x(), cube.y() + 1, cube.z()),
            new Point(cube.x(), cube.y(), cube.z() - 1),
            new Point(cube.x(), cube.y(), cube.z() + 1)));

    return neighbours;
  }

  private static Set<Point> getOuterShell(
      final Set<Point> inverse,
      final int minX,
      final int maxX,
      final int minY,
      final int maxY,
      final int minZ,
      final int maxZ) {
    return inverse.stream()
        .filter(
            node ->
                node.x() == minX
                    || node.x() == maxX
                    || node.y() == minY
                    || node.y() == maxY
                    || node.z() == minZ
                    || node.z() == maxZ)
        .collect(Collectors.toSet());
  }

  private static Set<Point> getInverse(
      final Set<Point> cubes,
      final int minX,
      final int maxX,
      final int minY,
      final int maxY,
      final int minZ,
      final int maxZ) {
    Set<Point> inverse = new HashSet<>();

    for (int x = minX; x <= maxX; ++x) {
      for (int y = minY; y <= maxY; ++y) {
        for (int z = minZ; z <= maxZ; ++z) {
          Point candidate = new Point(x, y, z);

          if (!cubes.contains(candidate)) {
            inverse.add(candidate);
          }
        }
      }
    }

    return inverse;
  }

  record Point(int x, int y, int z) {}
}
