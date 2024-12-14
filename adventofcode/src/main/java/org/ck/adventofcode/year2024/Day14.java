package org.ck.adventofcode.year2024;

import java.util.HashSet;
import java.util.LongSummaryStatistics;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241401,
    name = "Day 14: Restroom Redoubt",
    url = "https://adventofcode.com/2024/day/14",
    category = "2024")
@Solution(
    id = 20241402,
    name = "Day 14: Restroom Redoubt - Part 2",
    url = "https://adventofcode.com/2024/day/14#part2",
    category = "2024")
public class Day14 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "p=(?<xStart>-?\\d+),(?<yStart>-?\\d+) v=(?<xMovement>-?\\d+),(?<yMovement>-?\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day14::getRobotsPerQuadrant);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day14::findTree);
  }

  private void run(final Scanner in, final ToLongTriFunction<Set<Robot>, Long, Long> getResult) {
    final long xWidth = in.nextLong();
    final long yHeight = in.nextLong();
    in.nextLine();

    final Set<Robot> robots = new HashSet<>();

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());
      if (matcher.find()) {
        final long xMovement = (Long.parseLong(matcher.group("xMovement")) + xWidth) % xWidth;
        final long yMovement = (Long.parseLong(matcher.group("yMovement")) + yHeight) % yHeight;

        robots.add(
            new Robot(
                new Coordinate(
                    Long.parseLong(matcher.group("xStart")),
                    Long.parseLong(matcher.group("yStart"))),
                new Coordinate(xMovement, yMovement)));
      }
    }

    print(getResult.applyAsLong(robots, xWidth, yHeight));
  }

  private static Long getRobotsPerQuadrant(
      final Set<Robot> robots, final long xWidth, final long yHeight) {
    return moveRobots(robots, 100, xWidth, yHeight)
        .filter(endPosition -> endPosition.x() != xWidth / 2)
        .filter(endPosition -> endPosition.y() != yHeight / 2)
        .map(endPosition -> quadrantSelector(endPosition, xWidth, yHeight))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .values()
        .stream()
        .reduce(1L, (a, b) -> a * b);
  }

  private static long quadrantSelector(
      final Coordinate endPosition, final long xWidth, final long yHeight) {
    return ((endPosition.x() > xWidth / 2) ? 1L : 0L) + ((endPosition.y() > yHeight / 2) ? 2L : 0L);
  }

  private static long findTree(Set<Robot> robots, Long xWidth, Long yHeight) {
    long movements = 0;

    while (true) {
      final Set<Coordinate> endPositions =
          moveRobots(robots, movements, xWidth, yHeight).collect(Collectors.toSet());

      final long xVariance = getVariance(endPositions, Coordinate::x);
      final long yVariance = getVariance(endPositions, Coordinate::y);

      // these values are a guess after finding the tree manually
      if (xVariance < 400 && yVariance < 400) {
        return movements;
      }

      ++movements;
    }
  }

  private static long getVariance(Set<Coordinate> positions, ToLongFunction<Coordinate> toLong) {
    final LongSummaryStatistics stats = positions.stream().mapToLong(toLong).summaryStatistics();

    final long average = (long) stats.getAverage();

    return positions.stream()
            .mapToLong(toLong)
            .map(value -> (value - average) * (value - average))
            .sum()
        / stats.getCount();
  }

  private static Stream<Coordinate> moveRobots(
      final Set<Robot> robots, final long count, final long xWidth, final long yHeight) {
    return robots.stream()
        .map(
            robot ->
                new Coordinate(
                    (robot.start().x() + count * robot.movement().x()) % xWidth,
                    (robot.start().y() + count * robot.movement().y()) % yHeight));
  }

  private record Coordinate(long x, long y) {}

  private record Robot(Coordinate start, Coordinate movement) {}

  private interface ToLongTriFunction<A, B, C> {
    long applyAsLong(final A a, final B b, final C c);
  }
}
