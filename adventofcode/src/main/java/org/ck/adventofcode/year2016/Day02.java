package org.ck.adventofcode.year2016;

import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160201,
    name = "Day 2: Bathroom Security",
    url = "https://adventofcode.com/2016/day/2",
    category = "2016")
@Solution(
    id = 20160202,
    name = "Day 2: Bathroom Security - Part 2",
    url = "https://adventofcode.com/2016/day/2#part2",
    category = "2016")
public class Day02 extends AOCSolution {
  private static final char[][] PAD_1 =
      new char[][] {
        {' ', ' ', ' ', ' ', ' '},
        {' ', '1', '2', '3', ' '},
        {' ', '4', '5', '6', ' '},
        {' ', '7', '8', '9', ' '},
        {' ', ' ', ' ', ' ', ' '},
      };

  private static final char[][] PAD_2 =
      new char[][] {
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', '1', ' ', ' ', ' '},
        {' ', ' ', '2', '3', '4', ' ', ' '},
        {' ', '5', '6', '7', '8', '9', ' '},
        {' ', ' ', 'A', 'B', 'C', ' ', ' '},
        {' ', ' ', ' ', 'D', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' '},
      };

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, PAD_1, 2, 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, PAD_2, 1, 3);
  }

  private void run(final Scanner in, final char[][] pad, final int initialX, final int initialY) {
    final StringBuilder code = new StringBuilder();

    int x = initialX;
    int y = initialY;

    while (in.hasNextLine()) {
      for (final char direction : in.nextLine().toCharArray()) {
        int nextX = x;
        int nextY = y;

        switch (direction) {
          case 'U' -> nextY -= 1;
          case 'D' -> nextY += 1;
          case 'L' -> nextX -= 1;
          case 'R' -> nextX += 1;
          default -> throw new IllegalStateException("Unexpected value: " + direction);
        }

        if (pad[nextY][nextX] != ' ') {
          x = nextX;
          y = nextY;
        }
      }

      code.append(pad[y][x]);
    }

    print(code);
  }
}
