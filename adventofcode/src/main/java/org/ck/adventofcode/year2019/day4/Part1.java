package org.ck.adventofcode.year2019.day4;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20190401,
    name = "Day 4: Secure Container",
    url = "https://adventofcode.com/2019/day/4",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int min = in.nextInt();
      int max = in.nextInt();

      int count = 0;
      for (int i = min; i < max; ++i) {
        int lastDigit = i % 10;
        int num = i / 10;

        boolean correctOrder = true;
        boolean doubleDigit = false;
        while (num > 0) {
          int currentDigit = num % 10;

          if (currentDigit > lastDigit) {
            correctOrder = false;
            break;
          }

          if (currentDigit == lastDigit) {
            doubleDigit = true;
          }

          num = num / 10;
          lastDigit = currentDigit;
        }

        if (correctOrder && doubleDigit) {
          ++count;
        }
      }

      System.out.println(count);
    }
  }
}
