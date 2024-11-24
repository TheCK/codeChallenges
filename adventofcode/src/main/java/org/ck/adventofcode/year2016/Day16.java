package org.ck.adventofcode.year2016;

import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161601,
    name = "Day 16: Dragon Checksum",
    url = "https://adventofcode.com/2016/day/16",
    category = "2016")
@Solution(
    id = 20161602,
    name = "Day 16: Dragon Checksum - Part 2",
    url = "https://adventofcode.com/2016/day/16#part2",
    category = "2016")
public class Day16 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    StringBuilder data = new StringBuilder(in.nextLine());
    final int space = in.nextInt();

    while (data.length() < space) {
      final StringBuilder b = new StringBuilder();

      for (int i = data.length() - 1; i >= 0; --i) {
        if (data.charAt(i) == '1') {
          b.append('0');
        } else {
          b.append('1');
        }
      }

      data.append("0").append(b);
    }

    while (data.length() > space || data.length() % 2 == 0) {
      final StringBuilder check = new StringBuilder();

      for (int i = 0; i < Math.min(space, data.length()); i += 2) {
        if (data.charAt(i) == data.charAt(i + 1)) {
          check.append('1');
        } else {
          check.append('0');
        }
      }

      data = check;
    }

    print(data);
  }
}
