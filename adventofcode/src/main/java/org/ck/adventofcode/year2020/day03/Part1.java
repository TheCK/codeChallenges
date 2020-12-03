package org.ck.adventofcode.year2020.day03;

import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20200301,
    name = "Day 3: Toboggan Trajectory",
    url = "https://adventofcode.com/2020/day/3",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = 0;

      int x = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.charAt(x) == '#') {
          ++count;
        }

        x = (x + 3) % line.length();
      }

      System.out.println(count);
    }
  }
}
