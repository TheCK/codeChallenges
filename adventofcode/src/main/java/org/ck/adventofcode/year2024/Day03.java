package org.ck.adventofcode.year2024;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240301,
    name = "Day 3: Mull It Over",
    url = "https://adventofcode.com/2024/day/3",
    category = "2024")
@Solution(
    id = 20240302,
    name = "Day 3: Mull It Over - Part 2",
    url = "https://adventofcode.com/2024/day/3#part2",
    category = "2024")
public class Day03 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile("mul\\((?<one>\\d{1,3}),(?<two>\\d{1,3})\\)");
  private static final Pattern DEACTIVATION_PATTERN = Pattern.compile("don't\\(\\)");
  private static final Pattern ACTIVATION_PATTERN = Pattern.compile("do\\(\\)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean enableDisable) {
    final String input = readInput(in);

    int index = 0;
    final Matcher matcher = PATTERN.matcher(input);
    final Matcher deactivationMatcher = DEACTIVATION_PATTERN.matcher(input);
    final Matcher activeMatcher = ACTIVATION_PATTERN.matcher(input);

    long sum = 0;
    while (matcher.find(index)) {
      if (enableDisable
          && deactivationMatcher.find(index)
          && deactivationMatcher.start() < matcher.start()) {

        if (activeMatcher.find(deactivationMatcher.start())) {
          index = activeMatcher.end();
          continue;
        }

        break;
      }

      final long one = Long.parseLong(matcher.group("one"));
      final long two = Long.parseLong(matcher.group("two"));
      sum += one * two;

      index = matcher.end();
    }

    print(sum);
  }

  private static String readInput(final Scanner in) {
    final StringBuilder builder = new StringBuilder();

    while (in.hasNextLine()) {
      builder.append(in.nextLine());
    }

    return builder.toString();
  }
}
