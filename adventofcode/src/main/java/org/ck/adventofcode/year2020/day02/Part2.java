package org.ck.adventofcode.year2020.day02;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200202,
    name = "Day 2: Password Philosophy - Part 2",
    url = "https://adventofcode.com/2020/day/2#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        String[] positions = line[0].split("-");
        int first = Integer.parseInt(positions[0]) - 1;
        int last = Integer.parseInt(positions[1]) - 1;

        if (line[2].charAt(first) == line[1].charAt(0)
            ^ line[2].charAt(last) == line[1].charAt(0)) {
          ++count;
        }
      }

      System.out.println(count);
    }
  }
}
