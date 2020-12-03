package org.ck.adventofcode.year2020.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20200102,
    name = "Day 1: Report Repair - Part 2",
    url = "https://adventofcode.com/2020/day/1#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      int expected = in.nextInt();
      while (in.hasNextInt()) {
        numbers.add(in.nextInt());
      }

      for (int i = 0; i < numbers.size(); ++i) {
        for (int j = i; j < numbers.size(); ++j) {
          if (numbers.get(i) + numbers.get(j) > expected) {
            continue;
          }

          for (int k = j; k < numbers.size(); ++k) {
            if (numbers.get(i) + numbers.get(j) + numbers.get(k) == expected) {
              System.out.println(numbers.get(i) * numbers.get(j) * numbers.get(k));
              return;
            }
          }
        }
      }
    }
  }
}
