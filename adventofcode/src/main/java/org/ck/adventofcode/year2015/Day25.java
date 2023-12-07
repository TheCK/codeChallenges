package org.ck.adventofcode.year2015;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.NotImplementedException;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152501,
    name = "Day 25: Let It Snow",
    url = "https://adventofcode.com/2015/day/25",
    category = "2015")
public class Day25 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "To continue, please consult the code grid in the manual.  Enter the code at row (?<row>\\d+), column (?<column>\\d+).");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    throw new NotImplementedException();
  }

  private void run(final Scanner in) {
    Matcher matcher = PATTERN.matcher(in.nextLine());

    if (matcher.find()) {
      long r = Long.parseLong(matcher.group("row"));
      long c = Long.parseLong(matcher.group("column"));

      long value = 20151125;
      long cycles =
          ((c * (c + 1)) / 2) + (((c + (r - 2)) * (c + (r - 1))) / 2) - ((c * (c - 1)) / 2);

      for (long i = 1; i < cycles; ++i) {
        value *= 252533;
        value %= 33554393;
      }

      print(value);
    }
  }
}
