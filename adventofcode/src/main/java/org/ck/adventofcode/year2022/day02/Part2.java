package org.ck.adventofcode.year2022.day02;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20220202,
    name = "Day 2: Rock Paper Scissors - Part 2",
    url = "https://adventofcode.com/2022/day/2#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int points = 0;

      while (in.hasNextLine()) {
        String round = in.nextLine();
        points += getRoundPoints(round.charAt(2));
        points += getSymbolPoints(round.charAt(0), round.charAt(2));
      }

      System.out.println(points);
    }
  }

  private static int getSymbolPoints(final char theirs, final char strat) {
    return switch (strat) {
      case 'X' -> ((theirs - '?') % 3) + 1;
      case 'Y' -> theirs - '@';
      default -> ((theirs - '@') % 3) + 1;
    };
  }

  private static int getRoundPoints(final char strat) {
    return (strat - 'X') * 3;
  }
}
