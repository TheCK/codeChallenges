package org.ck.adventofcode.year2020.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201002,
    name = "Day 10: Adapter Array - Part 2",
    url = "https://adventofcode.com/2020/day/10#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> jolts = new ArrayList<>();
      while (in.hasNextInt()) {
        jolts.add(in.nextInt());
      }

      jolts.add(0);
      Collections.sort(jolts);

      long[] combos = new long[jolts.size()];
      combos[jolts.size() - 1] = 1;
      for (int i = jolts.size() - 2; i >= 0; --i) {
        for (int j = i + 1; j <= i + 3 && j < jolts.size(); ++j) {
          if (jolts.get(j) - jolts.get(i) <= 3) {
            combos[i] += combos[j];
          }
        }
      }

      System.out.println(combos[0]);
    }
  }
}
