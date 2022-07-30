package org.ck.adventofcode.year2016.day19;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20161902,
    name = "Day 19: An Elephant Named Joseph - Part 2",
    url = "https://adventofcode.com/2016/day/19",
    category = "2016")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int elves = in.nextInt();

      int[] gifts = new int[elves];
      for (int i = 0; i < elves; ++i) {
        gifts[i] = 1;
      }

      int i = 0;
      int inGame = elves;
      while (gifts[i] != elves) {
        if (gifts[i] != 0) {
          int next = (i + 1) % elves;

          int inGameCount = inGame / 2;
          while (inGameCount != 0) {
            if (gifts[next] != 0) {
              --inGameCount;
            }

            next = (next + 1) % elves;
          }
          --next;
          if (next < 0) {
            next = elves - 1;
          }

          if (i != next) {
            gifts[i] += gifts[next];
            gifts[next] = 0;
            --inGame;
          }
        }
        i = (i + 1) % elves;
      }

      System.out.println(i + 1);
    }
  }
}
