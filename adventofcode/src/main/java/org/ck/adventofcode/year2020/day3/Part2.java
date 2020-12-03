package org.ck.adventofcode.year2020.day3;

import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20200301,
    name = "Day 3: Toboggan Trajectory - Part 2",
    url = "https://adventofcode.com/2020/day/3#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count1 = 0;
      int count3 = 0;
      int count5 = 0;
      int count7 = 0;
      int count12 = 0;

      int x1 = 0;
      int x3 = 0;
      int x5 = 0;
      int x7 = 0;
      int x12 = 0;
      int y = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.charAt(x1) == '#') {
          ++count1;
        }
        if (line.charAt(x3) == '#') {
          ++count3;
        }
        if (line.charAt(x5) == '#') {
          ++count5;
        }
        if (line.charAt(x7) == '#') {
          ++count7;
        }
        if (y % 2 == 0) {
          if (line.charAt(x12) == '#') {
            ++count12;
          }

          x12 = (x12 + 1) % line.length();
        }

        x1 = (x1 + 1) % line.length();
        x3 = (x3 + 3) % line.length();
        x5 = (x5 + 5) % line.length();
        x7 = (x7 + 7) % line.length();
        ++y;
      }

      long product = (long) count1 * count3 * count5 * count7 * count12;
      System.out.println(product);
    }
  }
}
