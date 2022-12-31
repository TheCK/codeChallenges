package org.ck.adventofcode.year2016.day19;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161901,
    name = "Day 19: An Elephant Named Joseph",
    url = "https://adventofcode.com/2016/day/19",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int elves = in.nextInt();

      int[] gifts = new int[elves];
      for (int i = 0; i < elves; ++i) {
        gifts[i] = 1;
      }

      int i = 0;
      while (gifts[i] != elves) {
        if (gifts[i] != 0) {
          int next = (i + 1) % elves;
          while (gifts[next] == 0) {
            next = (next + 1) % elves;
          }

          if (i != next) {
            gifts[i] += gifts[next];
            gifts[next] = 0;
          }
        }
        i = (i + 1) % elves;
      }

      System.out.println(i + 1);
    }
  }
}
