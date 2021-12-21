package org.ck.adventofcode.year2021.day21;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20212102,
    name = "Day 21: Dirac Dice - Part 2",
    url = "https://adventofcode.com/2021/day/21#part2",
    category = "2021")
public class Part2 {
  private static final Pattern pattern = Pattern.compile("Player \\d starting position: (\\d+)");

  private static final String key = "%d-%d-%d-%d-%s-%d";
  private static Map<String, Long> cache;

  public static void main(String[] args) {
    cache = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      Matcher matcher1 = pattern.matcher(in.nextLine());
      matcher1.find();
      int one = Integer.parseInt(matcher1.group(1)) - 1;

      Matcher matcher2 = pattern.matcher(in.nextLine());
      matcher2.find();
      int two = Integer.parseInt(matcher2.group(1)) - 1;

      System.out.println(play(one, two, 0, 0, true, 3));
    }
  }

  private static long play(
      int p1pos,
      int p2pos,
      int p1points,
      int p2points,
      boolean turnPlayerOne,
      int remainingThrows) {
    String filledKey =
        String.format(key, p1pos, p2pos, p1points, p2points, turnPlayerOne, remainingThrows);

    if (cache.containsKey(filledKey)) {
      return cache.get(filledKey);
    }

    if (p1points >= 21) {
      return 1;
    } else if (p2points >= 21) {
      return 0;
    }

    boolean newTurnPlayerOne = turnPlayerOne;

    int newRemainingThrows = remainingThrows - 1;

    if (newRemainingThrows == 0) {
      newRemainingThrows = 3;
      newTurnPlayerOne = !newTurnPlayerOne;
    }

    long result = 0;
    if (turnPlayerOne) {
      result =
          play(
                  ((p1pos + 1) % 10),
                  p2pos,
                  remainingThrows == 1 ? p1points + ((p1pos + 1) % 10) + 1 : p1points,
                  p2points,
                  newTurnPlayerOne,
                  newRemainingThrows)
              + play(
                  ((p1pos + 2) % 10),
                  p2pos,
                  remainingThrows == 1 ? p1points + ((p1pos + 2) % 10) + 1 : p1points,
                  p2points,
                  newTurnPlayerOne,
                  newRemainingThrows)
              + play(
                  ((p1pos + 3) % 10),
                  p2pos,
                  remainingThrows == 1 ? p1points + ((p1pos + 3) % 10) + 1 : p1points,
                  p2points,
                  newTurnPlayerOne,
                  newRemainingThrows);
    } else {
      result =
          play(
                  p1pos,
                  ((p2pos + 1) % 10),
                  p1points,
                  remainingThrows == 1 ? p2points + ((p2pos + 1) % 10) + 1 : p2points,
                  newTurnPlayerOne,
                  newRemainingThrows)
              + play(
                  p1pos,
                  ((p2pos + 2) % 10),
                  p1points,
                  remainingThrows == 1 ? p2points + ((p2pos + 2) % 10) + 1 : p2points,
                  newTurnPlayerOne,
                  newRemainingThrows)
              + play(
                  p1pos,
                  ((p2pos + 3) % 10),
                  p1points,
                  remainingThrows == 1 ? p2points + ((p2pos + 3) % 10) + 1 : p2points,
                  newTurnPlayerOne,
                  newRemainingThrows);
    }

    cache.put(filledKey, result);
    return result;
  }
}
