package org.ck.adventofcode.year2021.day21;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20212101,
    name = "Day 21: Dirac Dice",
    url = "https://adventofcode.com/2021/day/21",
    category = "2021")
public class Part1 {
  private static final Pattern pattern = Pattern.compile("Player \\d starting position: (\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Matcher matcher1 = pattern.matcher(in.nextLine());
      matcher1.find();
      int one = Integer.parseInt(matcher1.group(1)) - 1;

      Matcher matcher2 = pattern.matcher(in.nextLine());
      matcher2.find();
      int two = Integer.parseInt(matcher2.group(1)) - 1;

      int points1 = 0;
      int points2 = 0;

      int die = 1;
      int numberOfThrows = 0;

      while (points2 < 1000) {
        int move = 0;
        for (int i = 0; i < 3; ++i) {
          move += die++;

          if (die == 101) {
            die = 1;
          }

          ++numberOfThrows;
        }

        points1 += ((one + move) % 10) + 1;
        one = ((one + move) % 10);

        if (points1 >= 1000) {
          break;
        }

        move = 0;
        for (int i = 0; i < 3; ++i) {
          move += die++;

          if (die == 101) {
            die = 1;
          }

          ++numberOfThrows;
        }

        points2 += ((two + move) % 10) + 1;
        two = ((two + move) % 10);
      }

      System.out.println((points1 >= 1000 ? points2 : points1) * numberOfThrows);
    }
  }
}
