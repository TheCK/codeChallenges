package org.ck.adventofcode.year2022.day06;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20220601,
    name = "Day 6: Tuning Trouble",
    url = "https://adventofcode.com/2022/day/6",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      int count = 4;
      while (count < line.length()) {
        if (checkUniqueness(line.substring(count - 4, count))) {
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
