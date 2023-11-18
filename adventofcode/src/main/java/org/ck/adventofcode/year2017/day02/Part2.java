package org.ck.adventofcode.year2017.day02;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170202,
    name = "Day 2: Corruption Checksum - Part 2",
    url = "https://adventofcode.com/2017/day/2#part2",
    category = "2017")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long sum = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split("\\s");

        sum += getLineNumber(line);
      }

      System.out.println(sum);
    }
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
