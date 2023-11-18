package org.ck.adventofcode.year2017.day04;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170402,
    name = "Day 4: High-Entropy Passphrases - Part 2",
    url = "https://adventofcode.com/2017/day/4#part2",
    category = "2017")
public class Part2 {
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
        if (isSameEnough(line[i], line[j])) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean isSameEnough(final String one, final String two) {
    if (one.length() != two.length()) {
      return false;
    }

    if (one.equals(two)) {
      return true;
    }

    final Map<String, Long> lettersInOne =
        Arrays.stream(one.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final Map<String, Long> lettersInTwo =
        Arrays.stream(two.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return lettersInOne.equals(lettersInTwo);
  }
}
