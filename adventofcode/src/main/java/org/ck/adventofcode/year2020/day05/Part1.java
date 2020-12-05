package org.ck.adventofcode.year2020.day05;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20200501,
    name = "Day 5: Binary Boarding",
    url = "https://adventofcode.com/2020/day/5",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int maxTicketId = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        int rowSteps =
            Math.min(
                line.contains("R") ? line.indexOf('R') : Integer.MAX_VALUE,
                line.contains("L") ? line.indexOf('L') : Integer.MAX_VALUE);
        int colSteps = line.length() - rowSteps;

        int maxRow = (int) Math.pow(2, rowSteps - 1);
        int maxCol = (int) Math.pow(2, colSteps - 1);

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
        maxTicketId = Math.max(maxTicketId, ticketId);
      }

      System.out.println(maxTicketId);
    }
  }
}
