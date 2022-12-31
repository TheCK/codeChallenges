package org.ck.adventofcode.year2020.day05;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200502,
    name = "Day 5: Binary Boarding - Part 2",
    url = "https://adventofcode.com/2020/day/5#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Set<Integer> ids = new HashSet<>();
      int maxPossibleId = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        int rowSteps =
            Math.min(
                line.contains("R") ? line.indexOf('R') : Integer.MAX_VALUE,
                line.contains("L") ? line.indexOf('L') : Integer.MAX_VALUE);
        int colSteps = line.length() - rowSteps;

        int maxRow = (int) Math.pow(2, rowSteps - 1);
        int maxCol = (int) Math.pow(2, colSteps - 1);

        maxPossibleId = 4 * maxRow * maxCol + maxCol;

        int row = 0;
        int i = 0;
        while (maxRow != 0) {
          if (line.charAt(i) == 'B') {
            row += maxRow;
          }
          maxRow /= 2;
          ++i;
        }

        int currentCol = maxCol;
        int col = 0;
        while (currentCol != 0) {
          if (line.charAt(i) == 'R') {
            col += currentCol;
          }
          currentCol /= 2;
          ++i;
        }

        int ticketId = 2 * maxCol * row + col;
        ids.add(ticketId);
      }

      for (int i = 0; i < maxPossibleId; ++i) {
        if (!ids.contains(i) && ids.contains(i - 1) && ids.contains(i + 1)) {
          System.out.println(i);
          break;
        }
      }
    }
  }
}
