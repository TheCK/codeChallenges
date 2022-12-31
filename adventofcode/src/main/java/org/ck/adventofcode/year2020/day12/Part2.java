package org.ck.adventofcode.year2020.day12;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201202,
    name = "Day 12: Rain Risk - Part 2",
    url = "https://adventofcode.com/2020/day/12#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int waypointX = 10;
      int waypointY = 1;
      int shipX = 0;
      int shipY = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        char order = line.charAt(0);
        switch (order) {
          case 'N':
            waypointY += Integer.parseInt(line.substring(1));
            break;
          case 'S':
            waypointY -= Integer.parseInt(line.substring(1));
            break;
          case 'E':
            waypointX += Integer.parseInt(line.substring(1));
            break;
          case 'W':
            waypointX -= Integer.parseInt(line.substring(1));
            break;
          case 'L':
          case 'R':
            int tmpX = waypointX;
            switch (line.substring(1)) {
              case "180":
                waypointX = -waypointX;
                waypointY = -waypointY;
                break;
              case "90":
                waypointX = waypointY * (order == 'R' ? 1 : -1);
                waypointY = -tmpX * (order == 'R' ? 1 : -1);
                break;
              case "270":
                waypointX = -waypointY * (order == 'R' ? 1 : -1);
                waypointY = tmpX * (order == 'R' ? 1 : -1);
                break;
            }
            break;
          case 'F':
            shipX += Integer.parseInt(line.substring(1)) * waypointX;
            shipY += Integer.parseInt(line.substring(1)) * waypointY;
            break;
        }
      }

      System.out.println(Math.abs(shipX) + Math.abs(shipY));
    }
  }
}
