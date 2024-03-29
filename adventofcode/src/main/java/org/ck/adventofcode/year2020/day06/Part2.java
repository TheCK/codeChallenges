package org.ck.adventofcode.year2020.day06;

import java.util.Arrays;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200602,
    name = "Day 6: Custom Customs - Part 2",
    url = "https://adventofcode.com/2020/day/6#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long count = 0;
      long[] answered = initArray();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isBlank()) {
          count += Arrays.stream(answered).filter(a -> a != 0).count();
          answered = initArray();
          continue;
        }

        for (char q = 'a'; q <= 'z'; ++q) {
          if (line.indexOf(q) == -1) {
            answered[q - 'a'] = 0;
          }
        }
      }

      count += Arrays.stream(answered).filter(a -> a != 0).count();
      System.out.println(count);
    }
  }

  private static long[] initArray() {
    long[] array = new long[26];

    for (int i = 0; i < 26; ++i) {
      array[i] = 1;
    }

    return array;
  }
}
