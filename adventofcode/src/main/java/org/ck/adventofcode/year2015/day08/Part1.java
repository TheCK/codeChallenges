package org.ck.adventofcode.year2015.day08;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150801,
    name = "Day 8: Matchsticks",
    url = "https://adventofcode.com/2015/day/8",
    category = "2015")
public class Part1 {
  public static void main(String[] args) throws Exception {
    int diff = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        String sanitized =
            line.replaceAll("\\\\\\\\", "#")
                .replaceAll("\\\\\"", "#")
                .replaceAll("\\\\x.{2}", "#")
                .replaceAll("\"", "");

        diff += line.length() - sanitized.length();
      }
    }

    System.out.println(diff);
  }
}
