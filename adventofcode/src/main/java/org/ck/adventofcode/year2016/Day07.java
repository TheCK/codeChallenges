package org.ck.adventofcode.year2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160701,
    name = "Day 7: Internet Protocol Version 7",
    url = "https://adventofcode.com/2016/day/7",
    category = "2016")
@Solution(
    id = 20160702,
    name = "Day 7: Internet Protocol Version 7 - Part 2",
    url = "https://adventofcode.com/2016/day/7#part2",
    category = "2016")
public class Day07 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        split -> {
          boolean outside = false;
          boolean inside = false;

          for (int i = 0; i < split.length; ++i) {
            for (int j = 0; j < split[i].length() - 3; ++j) {
              if (split[i].charAt(j) != split[i].charAt(j + 1)
                  && split[i].charAt(j) == split[i].charAt(j + 3)
                  && split[i].charAt(j + 1) == split[i].charAt(j + 2)) {
                if (i % 2 == 0) {
                  outside = true;
                } else {
                  inside = true;
                }
              }
            }
          }

          return outside && !inside;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        split -> {
          final List<String> outsides = new ArrayList<>();
          final List<String> insides = new ArrayList<>();
          for (int i = 0; i < split.length; ++i) {
            if (i % 2 == 0) {
              outsides.add(split[i]);
            } else {
              insides.add(split[i]);
            }
          }

          return isValid(outsides, insides);
        });
  }

  private void run(final Scanner in, final Predicate<String[]> isValid) {
    int valid = 0;

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split("[]\\[]");

      if (isValid.test(line)) {
        ++valid;
      }
    }

    print(valid);
  }

  private static boolean isValid(final List<String> outsides, final List<String> insides) {
    for (final String outside : outsides) {
      for (int i = 0; i < outside.length() - 2; ++i) {
        if (outside.charAt(i) == outside.charAt(i + 2)
            && outside.charAt(i) != outside.charAt(i + 1)) {
          for (final String inside : insides) {
            for (int j = 0; j < inside.length() - 2; ++j) {
              if (outside.charAt(i) == inside.charAt(j + 1)
                  && outside.charAt(i + 1) == inside.charAt(j)
                  && outside.charAt(i + 1) == inside.charAt(j + 2)) {
                return true;
              }
            }
          }
        }
      }
    }

    return false;
  }
}
