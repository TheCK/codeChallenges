package org.ck.adventofcode.year2016.day02;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20160201,
    name = "Day 2: Bathroom Security",
    url = "https://adventofcode.com/2016/day/2",
    category = "2016")
public class Part1 {
  private static char[][] pad = new char[][] {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

  public static void main(String[] args) {
    StringBuilder code = new StringBuilder();

    int x = 1;
    int y = 1;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        for (char direction : in.nextLine().toCharArray()) {
          switch (direction) {
            case 'U':
              y -= (y == 0 ? 0 : 1);
              break;
            case 'D':
              y += (y == 2 ? 0 : 1);
              break;
            case 'L':
              x -= (x == 0 ? 0 : 1);
              break;
            case 'R':
              x += (x == 2 ? 0 : 1);
              break;
          }
        }

        code.append(pad[y][x]);
      }
    }

    System.out.println(code);
  }
}
