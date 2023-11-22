package org.ck.adventofcode.year2017;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.Scanner;
import java.util.function.ToLongFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170201,
    name = "Day 2: Corruption Checksum",
    url = "https://adventofcode.com/2017/day/2",
    category = "2017")
@Solution(
    id = 20170202,
    name = "Day 2: Corruption Checksum - Part 2",
    url = "https://adventofcode.com/2017/day/2#part2",
    category = "2017")
public class Day02 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day02::getLineValueByDifference);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day02::getLineValueByDivision);
  }

  private void run(final Scanner in, final ToLongFunction<String[]> getLineValue) {
    long sum = 0;

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split("\\s");

      sum += getLineValue.applyAsLong(line);
    }

    print(sum);
  }

  private static long getLineValueByDifference(final String[] line) {
    final LongSummaryStatistics summary =
        Arrays.stream(line).mapToLong(Long::parseLong).summaryStatistics();

    return summary.getMax() - summary.getMin();
  }

  private static long getLineValueByDivision(final String[] line) {
    for (int i = 0; i < line.length - 1; ++i) {
      for (int j = i + 1; j < line.length; ++j) {
        final int first = Integer.parseInt(line[i]);
        final int second = Integer.parseInt(line[j]);

        if ((first / second) * second == first) {
          return first / second;
        }

        if ((second / first) * first == second) {
          return second / first;
        }
      }
    }

    return 0;
  }
}
