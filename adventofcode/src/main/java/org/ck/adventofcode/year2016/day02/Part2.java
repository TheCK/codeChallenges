package org.ck.adventofcode.year2016.day02;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20160202,
    name = "Day 2: Bathroom Security - Part 2",
    url = "https://adventofcode.com/2016/day/2#part2",
    category = "2016")
public class Part2 {
  private static char[][] pad =
      new char[][] {
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', '1', ' ', ' ', ' '},
        {' ', ' ', '2', '3', '4', ' ', ' '},
        {' ', '5', '6', '7', '8', '9', ' '},
        {' ', ' ', 'A', 'B', 'C', ' ', ' '},
        {' ', ' ', ' ', 'D', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
      };

  public static void main(String[] args) {
    StringBuilder code = new StringBuilder();

    int x = 1;
    int y = 3;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        for (char direction : in.nextLine().toCharArray()) {
          int nextX = x;
          int nextY = y;

          switch (direction) {
            case 'U':
              nextY -= 1;
              break;
            case 'D':
              nextY += 1;
              break;
            case 'L':
              nextX -= 1;
              break;
            case 'R':
              nextX += 1;
              break;
          }

          if (pad[nextY][nextX] != ' ') {
            x = nextX;
            y = nextY;
          }
        }

        code.append(pad[y][x]);
      }
    }

    System.out.println(code);
  }
}
