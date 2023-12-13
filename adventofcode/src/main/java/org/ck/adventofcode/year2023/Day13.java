package org.ck.adventofcode.year2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231301,
    name = "Day 13: Point of Incidence",
    url = "https://adventofcode.com/2023/day/13",
    category = "2023")
@Solution(
    id = 20231302,
    name = "Day 13: Point of Incidence - Part 2",
    url = "https://adventofcode.com/2023/day/13#part2",
    category = "2023")
public class Day13 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 1);
  }

  private void run(final Scanner in, final int wantedDifference) {
    final List<String> grid = new ArrayList<>();

    long sum = 0;
    while (in.hasNextLine()) {
      final String line = in.nextLine();

      if (line.isEmpty()) {
        sum += processGrid(grid, wantedDifference);
        grid.clear();
      } else {
        grid.add(line);
      }
    }

    sum += processGrid(grid, wantedDifference);

    print(sum);
  }

  private long processGrid(final List<String> grid, final int wantedDifference) {
    final long verticalMirrorRow =
        getMirrorValue(
            grid.getFirst().length(),
            index ->
                grid.stream()
                    .map(line -> line.substring(index, index + 1))
                    .collect(Collectors.joining()),
            wantedDifference);

    if (verticalMirrorRow != 0) {
      return verticalMirrorRow;
    }

    return 100L * getMirrorValue(grid.size(), grid::get, wantedDifference);
  }

  private long getMirrorValue(
      final int length, final IntFunction<String> mapper, final int wantedDifference) {
    for (int i = 1; i < length; ++i) {
      final int steps = Math.min(i, length - i);
      int differences = 0;

      for (int j = 1; j <= steps; ++j) {
        differences += getDifferences(mapper.apply(i - j), mapper.apply(i + j - 1));
      }

      if (differences == wantedDifference) {
        return i;
      }
    }

    return 0;
  }

  private int getDifferences(final String one, final String two) {
    int differences = 0;

    for (int i = 0; i < one.length(); ++i) {
      if (one.charAt(i) != two.charAt(i)) {
        ++differences;
      }
    }

    return differences;
  }
}
