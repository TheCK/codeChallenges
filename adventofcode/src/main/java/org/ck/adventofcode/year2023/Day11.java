package org.ck.adventofcode.year2023;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231101,
    name = "Day 11: Cosmic Expansion",
    url = "https://adventofcode.com/2023/day/11",
    category = "2023")
@Solution(
    id = 20231102,
    name = "Day 11: Cosmic Expansion - Part 2",
    url = "https://adventofcode.com/2023/day/11#part2",
    category = "2023")
public class Day11 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 1000000);
  }

  private void run(final Scanner in, final long expansionValue) {
    final Set<Galaxy> galaxies = getGalaxies(in);

    final Set<Integer> emptyRows = getEmptyValues(galaxies, Galaxy::row);
    final Set<Integer> emptyColumns = getEmptyValues(galaxies, Galaxy::column);

    long distance = 0;

    for (Galaxy one : galaxies) {
      for (Galaxy two : galaxies) {
        final int minRow = Math.min(one.row(), two.row());
        final int maxRow = Math.max(one.row(), two.row());
        distance += maxRow - minRow;
        distance +=
            (expansionValue - 1)
                * emptyRows.stream().filter(row -> row > minRow && row < maxRow).count();

        final int minColumn = Math.min(one.column(), two.column());
        final int maxColumn = Math.max(one.column(), two.column());
        distance += maxColumn - minColumn;
        distance +=
            (expansionValue - 1)
                * emptyColumns.stream()
                    .filter(column -> column > minColumn && column < maxColumn)
                    .count();
      }
    }

    print(distance / 2);
  }

  private static Set<Integer> getEmptyValues(
      final Set<Galaxy> galaxies, final Function<Galaxy, Integer> mapper) {
    final Set<Integer> used = galaxies.stream().map(mapper).collect(Collectors.toSet());
    final IntSummaryStatistics stats = used.stream().mapToInt(n -> n).summaryStatistics();

    return IntStream.range(0, stats.getMax())
        .filter(test -> !used.contains(test))
        .boxed()
        .collect(Collectors.toSet());
  }

  private static Set<Galaxy> getGalaxies(final Scanner in) {
    final Set<Galaxy> galaxies = new HashSet<>();
    int row = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      int column = 0;
      while (line.indexOf('#', column) != -1) {
        column = line.indexOf('#', column);

        galaxies.add(new Galaxy(row, column));
        ++column;
      }

      ++row;
    }

    return galaxies;
  }

  private record Galaxy(int row, int column) {}
}
