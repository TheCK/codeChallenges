package org.ck.adventofcode.year2022.day01;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20220102,
    name = "Day 1: Calorie Counting - Part 2",
    url = "https://adventofcode.com/2022/day/1#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int currentCals = 0;
      List<Integer> cals = new ArrayList<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isEmpty() || line.isBlank()) {
          cals.add(currentCals);
          currentCals = 0;
        } else {
          currentCals += Integer.parseInt(line);
        }
      }
      cals.add(currentCals);

      cals.sort(Collections.reverseOrder());

      System.out.println(cals.get(0) + cals.get(1) + cals.get(2));
    }
  }
}
