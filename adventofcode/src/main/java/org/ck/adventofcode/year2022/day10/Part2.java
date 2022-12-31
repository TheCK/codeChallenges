package org.ck.adventofcode.year2022.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20221002,
    name = "Day 10: Cathode-Ray Tube - Part 2",
    url = "https://adventofcode.com/2022/day/10#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int acc = 1;
      List<Integer> accHistory = new ArrayList<>();

      while (in.hasNextLine()) {
        String[] command = in.nextLine().split(" ");

        switch (command[0]) {
          case "noop":
            accHistory.add(acc);
            break;
          case "addx":
            accHistory.add(acc);
            accHistory.add(acc);
            acc = acc + Integer.parseInt(command[1]);
            break;
        }
      }

      StringBuilder screen = new StringBuilder();
      for (int i = 1; i <= 240; ++i) {
        if (Math.abs(accHistory.get(i - 1) - ((i - 1) % 40)) <= 1) {
          screen.append('#');
        } else {
          screen.append('.');
        }

        if (i % 40 == 0 && i != 240) {
          screen.append(System.lineSeparator());
        }
      }

      System.out.println(screen);
    }
  }
}
