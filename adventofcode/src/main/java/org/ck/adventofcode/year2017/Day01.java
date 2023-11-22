package org.ck.adventofcode.year2017;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170101,
    name = "Day 1: Inverse Captcha",
    url = "https://adventofcode.com/2017/day/1",
    category = "2017")
@Solution(
    id = 20170102,
    name = "Day 1: Inverse Captcha - Part 2",
    url = "https://adventofcode.com/2017/day/1#part2",
    category = "2017")
public class Day01 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (i, length) -> (i + 1) % length);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (i, length) -> (i + (length / 2)) % length);
  }

  private void run(final Scanner in, final IntBinaryOperator getIndexToCheck) {
    final String captcha = in.nextLine();

    long sum = 0;

    for (int i = 0; i < captcha.length(); ++i) {
      if (captcha.charAt(i) == captcha.charAt(getIndexToCheck.applyAsInt(i, captcha.length()))) {
        sum += captcha.charAt(i) - '0';
      }
    }

    print(sum);
  }
}
