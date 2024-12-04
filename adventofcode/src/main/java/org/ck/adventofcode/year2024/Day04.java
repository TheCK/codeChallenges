package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240401,
    name = "Day 4: Ceres Search",
    url = "https://adventofcode.com/2024/day/4",
    category = "2024")
@Solution(
    id = 20240402,
    name = "Day 4: Ceres Search - Part 2",
    url = "https://adventofcode.com/2024/day/4#part2",
    category = "2024")
public class Day04 extends AOCSolution {
  private static final String X_MAS_PATTERN =
      "([MS]).([MS]).{%1$d}A.{%1$d}((?!\\2)[MS]).((?!\\1)[MS])";

  @Override
  protected void runPartOne(final Scanner in) {
    List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine());
    }

    long count = 0;

    for (int i = 0; i < grid.size(); ++i) {
      for (int j = 0; j < grid.get(i).length(); ++j) {
        if (j < grid.get(i).length() - 3 && "XMAS".equals(grid.get(i).substring(j, j + 4))) {
          ++count;
        }
        if (j < grid.get(i).length() - 3 && "SAMX".equals(grid.get(i).substring(j, j + 4))) {
          ++count;
        }
        if (i < grid.size() - 3
            && grid.get(i).charAt(j) == 'X'
            && grid.get(i + 1).charAt(j) == 'M'
            && grid.get(i + 2).charAt(j) == 'A'
            && grid.get(i + 3).charAt(j) == 'S') {
          ++count;
        }
        if (i < grid.size() - 3
            && grid.get(i).charAt(j) == 'S'
            && grid.get(i + 1).charAt(j) == 'A'
            && grid.get(i + 2).charAt(j) == 'M'
            && grid.get(i + 3).charAt(j) == 'X') {
          ++count;
        }
        if (i < grid.size() - 3 && j < grid.get(i).length() - 3) {
          if (grid.get(i).charAt(j) == 'X'
              && grid.get(i + 1).charAt(j + 1) == 'M'
              && grid.get(i + 2).charAt(j + 2) == 'A'
              && grid.get(i + 3).charAt(j + 3) == 'S') {
            ++count;
          }
          if (grid.get(i).charAt(j) == 'S'
              && grid.get(i + 1).charAt(j + 1) == 'A'
              && grid.get(i + 2).charAt(j + 2) == 'M'
              && grid.get(i + 3).charAt(j + 3) == 'X') {
            ++count;
          }
          if (grid.get(i + 3).charAt(j) == 'X'
              && grid.get(i + 2).charAt(j + 1) == 'M'
              && grid.get(i + 1).charAt(j + 2) == 'A'
              && grid.get(i).charAt(j + 3) == 'S') {
            ++count;
          }
          if (grid.get(i + 3).charAt(j) == 'S'
              && grid.get(i + 2).charAt(j + 1) == 'A'
              && grid.get(i + 1).charAt(j + 2) == 'M'
              && grid.get(i).charAt(j + 3) == 'X') {
            ++count;
          }
        }
      }
    }

    print(count);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine());
    }

    final int lineLength = grid.getFirst().length();
    final Pattern pattern = Pattern.compile(X_MAS_PATTERN.formatted(lineLength - 2));
    final Matcher matcher = pattern.matcher(String.join("", grid));

    long count = 0;
    int start = 0;

    while (matcher.find(start)) {
      start = matcher.start() + 1;

      if (matcher.start() % lineLength < lineLength - 2) {
        ++count;
      }
    }

    print(count);
  }
}
