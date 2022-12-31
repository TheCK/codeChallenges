package org.ck.adventofcode.year2022.day10;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20221001,
    name = "Day 10: Cathode-Ray Tube",
    url = "https://adventofcode.com/2022/day/10",
    category = "2022")
public class Part1 {
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

      int signalStrength = 0;

      for (int i = 19; i < accHistory.size(); i += 40) {
        signalStrength += (i + 1) * accHistory.get(i);
      }

      System.out.println(signalStrength);
    }
  }
}
