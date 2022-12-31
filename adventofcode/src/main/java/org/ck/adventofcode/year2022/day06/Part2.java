package org.ck.adventofcode.year2022.day06;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20220602,
    name = "Day 6: Tuning Trouble - Part 2",
    url = "https://adventofcode.com/2022/day/6#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      int count = 14;
      while (count < line.length()) {
        if (checkUniqueness(line.substring(count - 14, count))) {
          System.out.println(count);
          return;
        }

        ++count;
      }
    }
  }

  private static boolean checkUniqueness(final String substring) {
    return substring.chars().distinct().count() == substring.length();
  }
}
