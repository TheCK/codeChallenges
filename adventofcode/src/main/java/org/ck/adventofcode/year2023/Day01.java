package org.ck.adventofcode.year2023;

import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230101,
    name = "Day 1: Trebuchet?!",
    url = "https://adventofcode.com/2023/day/1",
    category = "2023")
@Solution(
    id = 20230102,
    name = "Day 1: Trebuchet?! - Part 2",
    url = "https://adventofcode.com/2023/day/1#part2",
    category = "2023")
public class Day01 extends AOCSolution {
  private static final Pattern DIGIT_PATTERN = Pattern.compile("(\\d)");
  private static final Pattern EXTENDED_DIGIT_PATTERN =
      Pattern.compile("(\\d|one|two|three|four|five|six|seven|eight|nine)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, DIGIT_PATTERN, Integer::parseInt);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        EXTENDED_DIGIT_PATTERN,
        digit ->
            switch (digit) {
              case "one" -> 1;
              case "two" -> 2;
              case "three" -> 3;
              case "four" -> 4;
              case "five" -> 5;
              case "six" -> 6;
              case "seven" -> 7;
              case "eight" -> 8;
              case "nine" -> 9;
              default -> Integer.parseInt(digit);
            });
  }

  private void run(
      final Scanner in, final Pattern pattern, final ToIntFunction<String> getDigitAsInt) {
    int sum = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      final Matcher matcher = pattern.matcher(line);
      int start = 0;

      int first = 0;
      int last = 0;
      while (matcher.find(start)) {
        if (start == 0) {
          first = getDigitAsInt.applyAsInt(matcher.group(0));
          last = first;
        } else {
          last = getDigitAsInt.applyAsInt(matcher.group(0));
        }

        start = matcher.start(0) + 1;
      }

      sum += 10 * first + last;
    }

    print(sum);
  }
}
