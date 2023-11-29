package org.ck.adventofcode.year2015;

import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151001,
    name = "Day 10: Elves Look, Elves Say",
    url = "https://adventofcode.com/2015/day/10",
    category = "2015")
@Solution(
    id = 20151002,
    name = "Day 10: Elves Look, Elves Say - Part 2",
    url = "https://adventofcode.com/2015/day/10#part2",
    category = "2015")
public class Day10 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    String line = String.valueOf(in.nextInt());
    final int rounds = in.nextInt();

    for (int i = 0; i < rounds; ++i) {
      final StringBuilder newLine = new StringBuilder();

      char current = ' ';
      int count = 0;

      for (int j = 0; j < line.length(); ++j) {
        if (line.charAt(j) != current) {
          if (count > 0) {
            newLine.append(count);
            newLine.append(current);
          }

          current = line.charAt(j);
          count = 1;
        } else {
          ++count;
        }
      }

      if (count > 0) {
        newLine.append(count);
        newLine.append(current);
      }

      line = newLine.toString();
    }

    print(line.length());
  }
}
