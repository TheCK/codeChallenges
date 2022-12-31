package org.ck.adventofcode.year2016.day01;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160101,
    name = "Day 1: No Time for a Taxicab",
    url = "https://adventofcode.com/2016/day/1",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] instructions = in.nextLine().split(", ");

      int x = 0;
      int y = 0;
      int direction = 0;

      for (String instruction : instructions) {
        direction += (instruction.charAt(0) == 'R' ? 1 : -1);

        if (direction == 4) {
          direction = 0;
        } else if (direction == -1) {
          direction = 3;
        }

        switch (direction) {
          case 0:
            y -= Integer.parseInt(instruction.substring(1));
            break;
          case 2:
            y += Integer.parseInt(instruction.substring(1));
            break;
          case 1:
            x += Integer.parseInt(instruction.substring(1));
            break;
          case 3:
            x -= Integer.parseInt(instruction.substring(1));
            break;
        }
      }

      System.out.println(Math.abs(x) + Math.abs(y));
    }
  }
}
