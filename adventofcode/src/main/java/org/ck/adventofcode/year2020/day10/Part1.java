package org.ck.adventofcode.year2020.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201001,
    name = "Day 10: Adapter Array",
    url = "https://adventofcode.com/2020/day/10",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> jolts = new ArrayList<>();
      while (in.hasNextInt()) {
        jolts.add(in.nextInt());
      }

      jolts.add(0);
      Collections.sort(jolts);

      int ones = 0;
      int threes = 0;
      for (int i = 1; i < jolts.size(); ++i) {
        switch (jolts.get(i) - jolts.get(i - 1)) {
          case 1:
            ++ones;
            break;
          case 3:
            ++threes;
            break;
        }
      }

      ++threes;
      System.out.println(ones * threes);
    }
  }
}
