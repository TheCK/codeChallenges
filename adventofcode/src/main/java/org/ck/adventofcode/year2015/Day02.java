package org.ck.adventofcode.year2015;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150201,
    name = "Day 2: I Was Told There Would Be No Math",
    url = "https://adventofcode.com/2015/day/2",
    category = "2015")
@Solution(
    id = 20150202,
    name = "Day 2: I Was Told There Would Be No Math - Part 2",
    url = "https://adventofcode.com/2015/day/2#part2",
    category = "2015")
public class Day02 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (l, w, h) -> {
          final int lw = l * w;
          final int lh = l * h;
          final int wh = w * h;

          final int min = Math.min(Math.min(lw, lh), wh);

          return 2 * lw + 2 * lh + 2 * wh + min;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (l, w, h) -> {
          final List<Integer> lengths = Arrays.asList(l, w, h);
          Collections.sort(lengths);

          final int s = lengths.get(0);
          final int m = lengths.get(1);

          return 2 * s + 2 * m + l * w * h;
        });
  }

  private void run(final Scanner in, final MaterialNeedCalculator materialNeedCalculator) {
    int needed = 0;

    while (in.hasNextLine()) {
      final String[] dimensions = in.nextLine().split("x");

      final int l = Integer.parseInt(dimensions[0]);
      final int w = Integer.parseInt(dimensions[1]);
      final int h = Integer.parseInt(dimensions[2]);

      needed += materialNeedCalculator.get(l, w, h);
    }

    print(needed);
  }

  private interface MaterialNeedCalculator {
    int get(final int l, final int w, final int h);
  }
}
