package org.ck.adventofcode.year2025;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToLongBiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250701,
    name = "Day 7: Laboratories ",
    url = "https://adventofcode.com/2025/day/7",
    category = "2025")
@Solution(
    id = 20250702,
    name = "Day 7: Laboratories - Part 2",
    url = "https://adventofcode.com/2025/day/7#part2",
    category = "2025")
public class Day07 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (count, _) -> count.get());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (_, paths) -> Arrays.stream(paths).sum());
  }

  private void run(final Scanner in, final ToLongBiFunction<AtomicInteger, long[]> resultGetter) {
    final List<String> lines = new ArrayList<>();
    long[] paths = null;

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      final int start = line.indexOf('S');
      if (start > 0) {
        paths = new long[line.length()];
        paths[start] = 1;
      }

      lines.add(line);
    }

    if (paths == null) {
      throw new RuntimeException("No strat found");
    }

    final AtomicInteger splits = new AtomicInteger(0);
    for (String line : lines) {
      for (int column = 0; column < line.length(); ++column) {
        if (line.charAt(column) == '^') {
          if (paths[column] > 0) {
            paths[column - 1] += paths[column];
            paths[column + 1] += paths[column];

            paths[column] = 0;

            splits.incrementAndGet();
          }
        }
      }
    }

    print(resultGetter.applyAsLong(splits, paths));
  }
}
