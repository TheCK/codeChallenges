package org.ck.adventofcode.year2017;

import java.util.*;
import java.util.function.ToLongFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170201,
    name = "Day 2: Corruption Checksum",
    url = "https://adventofcode.com/2017/day/2",
    category = "2017")
@Solution(
    id = 20170202,
    name = "Day 2: Corruption Checksum - Part 2",
    url = "https://adventofcode.com/2017/day/2#part2",
    category = "2017")
public class Day02 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day02::getLineValueByDifference);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day02::getLineValueByDivision);
  }

  private void run(final Scanner in, final ToLongFunction<List<Long>> getLineValue) {
    long sum = 0;

    while (in.hasNextLine()) {
      final List<Long> line =
          new ArrayList<>(Arrays.stream(in.nextLine().split("\\s")).map(Long::valueOf).toList());

      sum += getLineValue.applyAsLong(line);
    }

    print(sum);
  }

  private static long getLineValueByDifference(final List<Long> line) {
    Collections.sort(line);

    return line.getLast() - line.getFirst();
  }

  private static long getLineValueByDivision(final List<Long> line) {
    for (int i = 0; i < line.size() - 1; ++i) {
      for (int j = i + 1; j < line.size(); ++j) {
        final long first = line.get(i);
        final long second = line.get(j);

        if ((first / second) * second == first) {
          return first / second;
        }

        if ((second / first) * first == second) {
          return second / first;
        }
      }
    }

    return 0;
  }
}
