package org.ck.adventofcode.year2020.day12;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20201201,
    name = "Day 12: Rain Risk",
    url = "https://adventofcode.com/2020/day/12",
    category = "2020")
public class Part1 {
  private static final int[][] directions = new int[][] {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int direction = 0;
      int x = 0;
      int y = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        switch (line.charAt(0)) {
          case 'N':
            y += Integer.parseInt(line.substring(1));
            break;
          case 'S':
            y -= Integer.parseInt(line.substring(1));
            break;
          case 'E':
            x += Integer.parseInt(line.substring(1));
            break;
          case 'W':
            x -= Integer.parseInt(line.substring(1));
            break;
          case 'L':
            direction = direction - (Integer.parseInt(line.substring(1)) / 90);
            if (direction < 0) {
              direction += 4;
            }
            break;
          case 'R':
            direction = (direction + (Integer.parseInt(line.substring(1)) / 90)) % 4;
            break;
          case 'F':
            x += directions[direction][0] * Integer.parseInt(line.substring(1));
            y += directions[direction][1] * Integer.parseInt(line.substring(1));
            break;
        }
      }

      System.out.println(Math.abs(x) + Math.abs(y));
    }
  }
}
