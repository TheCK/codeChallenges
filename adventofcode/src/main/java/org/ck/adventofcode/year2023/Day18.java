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
    category = "2023")
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
    final Set<Corner> corners = getCorners(in, getCommand);

    final List<Long> rowsWithCorners =
        corners.stream().mapToLong(Corner::row).distinct().sorted().boxed().toList();
    final Set<Range> ranges = new HashSet<>();

    long filled = 0;

    for (int rowIndex = 0; rowIndex < rowsWithCorners.size() - 1; ++rowIndex) {
      final long row = rowsWithCorners.get(rowIndex);
      final List<Long> columnsWithCorners =
          corners.stream()
              .filter(corner -> corner.row() == row)
              .mapToLong(Corner::column)
              .sorted()
              .boxed()
              .toList();

      for (int i = 0; i < columnsWithCorners.size(); i += 2) {
        final long start = columnsWithCorners.get(i);
        final long end = columnsWithCorners.get(i + 1);

        final Optional<Range> maybeRangeWithStartInside =
            ranges.stream().filter(range -> range.isWithin(start)).findAny();

        final Optional<Range> maybeRangeWithEndInside =
            ranges.stream().filter(range -> range.isWithin(end)).findAny();

        if (maybeRangeWithStartInside.isEmpty() && maybeRangeWithEndInside.isEmpty()) {
          ranges.add(new Range(start, end));
        } else if (maybeRangeWithStartInside.isPresent() && maybeRangeWithEndInside.isPresent()) {
          filled +=
              handleOverlappingRanges(
                  maybeRangeWithStartInside.get(),
                  maybeRangeWithEndInside.get(),
                  ranges,
                  start,
                  end);
        } else if (maybeRangeWithStartInside.isPresent()) {
          final Range rangeWithStartInside = maybeRangeWithStartInside.get();
          ranges.remove(rangeWithStartInside);
          ranges.add(new Range(rangeWithStartInside.start(), end));
        } else {
          final Range rangeWithEndInside = maybeRangeWithEndInside.get();
          ranges.remove(rangeWithEndInside);
          ranges.add(new Range(start, rangeWithEndInside.end()));
        }
      }

      filled +=
          (rowsWithCorners.get(rowIndex + 1) - row)
              * ranges.stream().mapToLong(Range::length).sum();
    }
    filled += ranges.stream().mapToLong(Range::length).sum();

    print(filled);
  }

  private static long handleOverlappingRanges(
      final Range rangeWithStartInside,
      final Range rangeWithEndInside,
      final Set<Range> ranges,
      final long start,
      final long end) {
    long extraFilled = 0;

    ranges.remove(rangeWithStartInside);

    if (rangeWithStartInside == rangeWithEndInside) {
      if (rangeWithStartInside.start() != start && rangeWithEndInside.end() != end) {
        extraFilled += end - start - 1;
      } else if (rangeWithStartInside.start() == start && rangeWithEndInside.end() == end) {
        extraFilled += end - start + 1;
      } else {
        extraFilled += end - start;
      }

      if (rangeWithStartInside.start() != start) {
        ranges.add(new Range(rangeWithStartInside.start(), start));
      }
      if (rangeWithEndInside.end() != end) {
        ranges.add(new Range(end, rangeWithEndInside.end()));
      }
    } else {
      ranges.remove(rangeWithEndInside);
      ranges.add(new Range(rangeWithStartInside.start(), rangeWithEndInside.end()));
    }

    return extraFilled;
  }

  private static Set<Corner> getCorners(
      final Scanner in, final Function<String[], Command> getCommand) {
    final Set<Corner> corners = new HashSet<>();
    corners.add(new Corner(0, 0));

    long row = 0;
    long column = 0;

    while (in.hasNextLine()) {
      final Command command = getCommand.apply(in.nextLine().split(" "));

      switch (command.direction()) {
        case RIGHT -> column += command.length();
        case LEFT -> column -= command.length();
        case UP -> row -= command.length();
        case DOWN -> row += command.length();
      }

      corners.add(new Corner(row, column));
    }

    return corners;
  }

  private record Range(long start, long end) {
    public boolean isWithin(long value) {
      return start <= value && value <= end;
    }

    public long length() {
      return end - start + 1;
    }
  }

  private record Command(Direction direction, long length) {}

  private record Corner(long row, long column) {}

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }
}
