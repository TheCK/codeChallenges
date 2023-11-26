package org.ck.adventofcode.year2015;

import java.util.Scanner;
import java.util.function.ToIntBiFunction;
import java.util.function.UnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150801,
    name = "Day 8: Matchsticks",
    url = "https://adventofcode.com/2015/day/8",
    category = "2015")
@Solution(
    id = 20150802,
    name = "Day 8: Matchsticks - Part 2",
    url = "https://adventofcode.com/2015/day/8#part2",
    category = "2015")
public class Day08 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        input ->
            input
                .replace("\\\\", "#")
                .replace("\\\"", "#")
                .replaceAll("\\\\x.{2}", "#")
                .replace("\"", ""),
        (input, sanitized) -> input.length() - sanitized.length());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        input -> input.replace("\\", "##").replace("\"", "#\""),
        (input, sanitized) -> sanitized.length() - input.length() + 2);
  }

  private void run(
      final Scanner in,
      final UnaryOperator<String> sanitizer,
      final ToIntBiFunction<String, String> getLineValue) {
    int diff = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      final String sanitized = sanitizer.apply(line);

      diff += getLineValue.applyAsInt(line, sanitized);
    }

    print(diff);
  }
}
