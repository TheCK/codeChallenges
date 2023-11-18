package org.ck.adventofcode.year2017.day02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170201,
    name = "Day 2: Corruption Checksum",
    url = "https://adventofcode.com/2017/day/2",
    category = "2017")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long sum = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split("\\s");

        final IntSummaryStatistics summary =
            Arrays.stream(line).mapToInt(Integer::parseInt).summaryStatistics();

        sum += summary.getMax() - summary.getMin();
      }

      System.out.println(sum);
    }
  }
}
