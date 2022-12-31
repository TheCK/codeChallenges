package org.ck.adventofcode.year2015.day25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152501,
    name = "Day 25: Let It Snow",
    url = "https://adventofcode.com/2015/day/25",
    category = "2015")
public class Part1 {
  private static final Pattern pattern =
      Pattern.compile(
          "To continue, please consult the code grid in the manual.  Enter the code at row (\\d+), column (\\d+).");

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      Matcher matcher = pattern.matcher(in.nextLine());

      if (matcher.find()) {
        long r = Long.parseLong(matcher.group(1));
        long c = Long.parseLong(matcher.group(2));

        long value = 20151125;
        long cycles =
            ((c * (c + 1)) / 2) + (((c + (r - 2)) * (c + (r - 1))) / 2) - ((c * (c - 1)) / 2);

        for (long i = 1; i < cycles; ++i) {
          value *= 252533;
          value %= 33554393;
        }

        System.out.println(value);
      }
    }
  }
}
