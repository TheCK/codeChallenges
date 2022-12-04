package org.ck.adventofcode.year2022.day04;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20220402,
    name = "Day 4: Camp Cleanup - Part 2",
    url = "https://adventofcode.com/2022/day/4#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int overlaps = 0;

      while (in.hasNextLine()) {
        final String[] elves = in.nextLine().split(",");

        String[] elf1 = elves[0].split("-");
        String[] elf2 = elves[1].split("-");

        int elf1Start = Integer.parseInt(elf1[0]);
        int elf1End = Integer.parseInt(elf1[1]);

        int elf2Start = Integer.parseInt(elf2[0]);
        int elf2End = Integer.parseInt(elf2[1]);

        if (elf1Start >= elf2Start && elf1Start <= elf2End
            || elf2Start >= elf1Start && elf2Start <= elf1End) {
          ++overlaps;
        }
      }

      System.out.println(overlaps);
    }
  }
}
