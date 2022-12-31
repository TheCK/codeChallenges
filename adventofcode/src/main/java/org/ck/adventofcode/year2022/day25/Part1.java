package org.ck.adventofcode.year2022.day25;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20222501,
    name = "Day 25: Full of Hot Air",
    url = "https://adventofcode.com/2022/day/25",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    long sum = 0;
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        long number = getNumber(line);

        sum += number;
      }
    }

    System.out.println(getSnafu(sum));
  }

  private static String getSnafu(final long number) {
    if (number == 0) {
      return "";
    }

    int mod = (int) (number % 5);
    return switch (mod) {
      case 0, 1, 2 -> getSnafu(number / 5) + mod;
      case 3, 4 -> getSnafu(number / 5 + 1) + (mod == 3 ? "=" : '-');
      default -> throw new UnsupportedOperationException();
    };
  }

  private static long getNumber(final String line) {
    long number = 0;
    long pow = 0;
    for (int i = line.length() - 1; i >= 0; --i) {
      if (Character.isDigit(line.charAt(i))) {
        number += (long) (Math.pow(5, pow) * (line.charAt(i) - '0'));
      } else {
        number -= (long) (Math.pow(5, pow) * (line.charAt(i) == '=' ? 2 : 1));
      }

      ++pow;
    }
    return number;
  }
}
