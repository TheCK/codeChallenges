package org.ck.adventofcode.year2020.day06;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Arrays;
import java.util.Scanner;

@Solution(
    id = 20200601,
    name = "Day 6: Custom Customs",
    url = "https://adventofcode.com/2020/day/6",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      StringBuilder builder = new StringBuilder();
      int count = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (!line.isBlank()) {
          builder.append(" ").append(line.trim());

          if (in.hasNextLine()) {
            continue;
          }
        }

        int[] answered = new int[26];
        String allAnswers = builder.toString();
        for (char q = 'a'; q <= 'z'; ++q) {
          answered[q - 'a'] = allAnswers.indexOf(q);
        }

        count += Arrays.stream(answered).filter(a -> a != -1).count();
        builder = new StringBuilder();
      }

      System.out.println(count);
    }
  }
}
