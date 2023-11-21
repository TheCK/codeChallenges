package org.ck.adventofcode.year2017;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170401,
    name = "Day 4: High-Entropy Passphrases",
    url = "https://adventofcode.com/2017/day/4",
    category = "2017")
@Solution(
    id = 20170402,
    name = "Day 4: High-Entropy Passphrases - Part 2",
    url = "https://adventofcode.com/2017/day/4#part2",
    category = "2017")
public class Day04 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, String::equals);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day04::isSameEnough);
  }

  private void run(final Scanner in, final BiPredicate<String, String> invalidator) {
    long validPassphrases = 0;

    while (in.hasNextLine()) {
      String[] line = in.nextLine().split("\\s");

      if (!isInvalid(line, invalidator)) {
        ++validPassphrases;
      }
    }

    print(validPassphrases);
  }

  private static boolean isInvalid(String[] line, BiPredicate<String, String> invalidator) {
    for (int i = 0; i < line.length - 1; ++i) {
      for (int j = i + 1; j < line.length; ++j) {
        if (invalidator.test(line[i], line[j])) {
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
