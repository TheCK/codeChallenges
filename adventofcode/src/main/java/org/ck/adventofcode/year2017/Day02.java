package org.ck.adventofcode.year2017;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
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
    long sum = 0;

    while (in.hasNextLine()) {
      String[] line = in.nextLine().split("\\s");

      final IntSummaryStatistics summary =
          Arrays.stream(line).mapToInt(Integer::parseInt).summaryStatistics();

      sum += summary.getMax() - summary.getMin();
    }

    print(sum);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    long sum = 0;

    while (in.hasNextLine()) {
      String[] line = in.nextLine().split("\\s");

      sum += getLineNumber(line);
    }

    print(sum);
  }

  private static long getLineNumber(final String[] line) {
    for (int i = 0; i < line.length - 1; ++i) {
      for (int j = i + 1; j < line.length; ++j) {
        int first = Integer.parseInt(line[i]);
        int second = Integer.parseInt(line[j]);

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
