package org.ck.adventofcode.year2015.day08;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20150802,
    name = "Day 8: Matchsticks - Part 2",
    url = "https://adventofcode.com/2015/day/8#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) throws Exception {
    int diff = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String sanitized = line.replaceAll("\\\\", "##").replaceAll("\"", "#\"");

        diff += sanitized.length() - line.length() + 2;
      }
    }

    System.out.println(diff);
  }
}
