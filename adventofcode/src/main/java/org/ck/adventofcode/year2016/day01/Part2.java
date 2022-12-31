package org.ck.adventofcode.year2016.day01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160102,
    name = "Day 1: No Time for a Taxicab - Part 2",
    url = "https://adventofcode.com/2016/day/1#part2",
    category = "2016")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] instructions = in.nextLine().split(", ");

      Set<Point> visited = new HashSet<>();
      visited.add(new Point(0, 0));

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

        int distance = Integer.parseInt(instruction.substring(1));

        for (int i = 0; i < distance; ++i) {
          switch (direction) {
            case 0:
              y -= 1;
              break;
            case 2:
              y += 1;
              break;
            case 1:
              x += 1;
              break;
            case 3:
              x -= 1;
              break;
          }

          Point current = new Point(x, y);
          if (visited.contains(current)) {
            System.out.println(Math.abs(x) + Math.abs(y));
            return;
          }

          visited.add(current);
        }
      }
    }
  }

  record Point(int x, int y) {}
}
