package org.ck.adventofcode.year2022.day01;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20220101,
    name = "Day 1: Calorie Counting",
    url = "https://adventofcode.com/2022/day/1",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int currentCals = 0;
      int maxCals = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isEmpty() || line.isBlank()) {
          maxCals = Math.max(maxCals, currentCals);
          currentCals = 0;
        } else {
          currentCals += Integer.parseInt(line);
        }
      }
      maxCals = Math.max(maxCals, currentCals);

      System.out.println(maxCals);
    }
  }
}
