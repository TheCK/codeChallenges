package org.ck.adventofcode.year2022.day02;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20220201,
    name = "Day 2: Rock Paper Scissors",
    url = "https://adventofcode.com/2022/day/2",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int points = 0;

      while (in.hasNextLine()) {
        String round = in.nextLine();
        points += getRoundPoints(round.charAt(0), round.charAt(2));
        points += getSymbolPoints(round);
      }

      System.out.println(points);
    }
  }

  private static int getSymbolPoints(final String round) {
    return round.charAt(2) - 'W';
  }

  private static int getRoundPoints(final char theirs, final char ours) {
    if (theirs - 'A' == ours - 'X') {
      return 3;
    }

    if ((theirs == 'A' && ours == 'Y')
        || (theirs == 'B' && ours == 'Z')
        || (theirs == 'C' && ours == 'X')) {
      return 6;
    }

    return 0;
  }
}
