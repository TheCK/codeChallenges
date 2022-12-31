package org.ck.adventofcode.year2019.day04;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20190402,
    name = "Day 4: Secure Container - Part 2",
    url = "https://adventofcode.com/2019/day/4#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int min = in.nextInt();
      int max = in.nextInt();

      int count = 0;
      for (int i = min; i < max; ++i) {
        int lastDigit = i % 10;
        int num = i / 10;
        int currentDigitCount = 1;

        boolean correctOrder = true;
        List<Integer> consecutiveDigitCount = new ArrayList<>();
        while (num > 0) {
          int currentDigit = num % 10;

          if (currentDigit > lastDigit) {
            correctOrder = false;
            break;
          }

          if (currentDigit == lastDigit) {
            currentDigitCount += 1;
          } else {
            consecutiveDigitCount.add(currentDigitCount);
            currentDigitCount = 1;
          }

          num = num / 10;
          lastDigit = currentDigit;
        }
        consecutiveDigitCount.add(currentDigitCount);

        if (correctOrder && consecutiveDigitCount.stream().anyMatch(x -> x == 2)) {
          ++count;
        }
      }

      System.out.println(count);
    }
  }
}
