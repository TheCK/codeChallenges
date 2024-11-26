package org.ck.adventofcode.year2016;

import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161801,
    name = "Day 18: Like a Rogue",
    url = "https://adventofcode.com/2016/day/18",
    category = "2016")
@Solution(
    id = 20161802,
    name = "Day 18: Like a Rogue - Part 2",
    url = "https://adventofcode.com/2016/day/18",
    category = "2016")
public class Day18 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    String line = ".%s.".formatted(in.nextLine());
    final int rows = in.nextInt();

    long safe = getSafeTiles(line);

    for (int i = 1; i < rows; ++i) {
      line = getNextRow(line, i);
      safe += getSafeTiles(line);
    }

    print(safe);
  }

  private static long getSafeTiles(final String line) {
    long safe = 0;

    for (int i = 1; i < line.length() - 1; ++i) {
      if (line.charAt(i) == '.') {
        ++safe;
      }
    }

    return safe;
  }

  private static String getNextRow(final String line, final int row) {
    final StringBuilder newLine = new StringBuilder().append('.');

    for (int j = 1; j < line.length() - 1; ++j) {
      final char left = line.charAt(j - 1);
      final char center = line.charAt(j);
      final char right = line.charAt(j + 1);

      if (left == center && center != right || left != center && center == right) {
        newLine.append('^');
      } else {
        newLine.append('.');
      }
    }

    return newLine.append('.').toString();
  }
}
