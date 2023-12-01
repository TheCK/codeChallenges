package org.ck.adventofcode.year2015;

import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151101,
    name = "Day 11: Corporate Policy",
    url = "https://adventofcode.com/2015/day/11",
    category = "2015")
@Solution(
    id = 20151102,
    name = "Day 11: Corporate Policy - Part 2",
    url = "https://adventofcode.com/2015/day/11#part2",
    category = "2015")
public class Day11 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final char[] password = in.nextLine().toCharArray();

    while (true) {
      increment(password);

      final String candidate = String.copyValueOf(password);
      if (isValid(candidate)) {
        print(candidate);
        return;
      }
    }
  }

  private static void increment(final char[] password) {
    int pos = password.length - 1;

    boolean cont = true;
    while (cont) {
      password[pos]++;
      if (password[pos] > 'z') {
        password[pos] = 'a';
        --pos;
      } else {
        cont = false;
      }
    }
  }

  private static boolean isValid(final String candidate) {
    if (candidate.contains("i") || candidate.contains("0") || candidate.contains("l")) {
      return false;
    }

    int doubles = 0;
    int last = ' ';
    for (int i = 0; i < candidate.length(); ++i) {
      if (last == candidate.charAt(i)) {
        ++doubles;
        ++i;
      }

      if (i < candidate.length()) {
        last = candidate.charAt(i);
      }
    }

    boolean hasSequence = false;
    for (int i = 2; i < candidate.length(); ++i) {
      if (candidate.charAt(i) == candidate.charAt(i - 1) + 1
          && candidate.charAt(i - 1) == candidate.charAt(i - 2) + 1) {
        hasSequence = true;
        break;
      }
    }

    return doubles > 1 && hasSequence;
  }
}
