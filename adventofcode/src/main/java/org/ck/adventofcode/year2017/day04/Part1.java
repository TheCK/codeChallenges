package org.ck.adventofcode.year2017.day04;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170401,
    name = "Day 4: High-Entropy Passphrases",
    url = "https://adventofcode.com/2017/day/4",
    category = "2017")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long validPassphrases = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split("\\s");

        if (!hasDouble(line)) {
          ++validPassphrases;
        }
      }

      System.out.println(validPassphrases);
    }
  }

  private static boolean hasDouble(String[] line) {
    for (int i = 0; i < line.length - 1; ++i) {
      for (int j = i + 1; j < line.length; ++j) {
        if (line[i].equals(line[j])) {
          return true;
        }
      }
    }

    return false;
  }
}
