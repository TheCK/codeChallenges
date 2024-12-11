package org.ck.adventofcode.year2024;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241101,
    name = "Day 11: Plutonian Pebbles",
    url = "https://adventofcode.com/2024/day/11",
    category = "2024")
@Solution(
    id = 20241102,
    name = "Day 11: Plutonian Pebbles - Part 2",
    url = "https://adventofcode.com/2024/day/11#part2",
    category = "2024")
public class Day11 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 25);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 75);
  }

  private void run(final Scanner in, final int steps) {
    final List<Long> numbers =
        Arrays.stream(in.nextLine().split(" ")).map(Long::parseLong).toList();

    final Map<String, Long> cache = new HashMap<>();
    long sum = 0;

    for (Long number : numbers) {
      sum += getValueAfterSteps(cache, number, steps);
    }

    print(sum);
  }

  private long getValueAfterSteps(
      final Map<String, Long> cache, final Long number, final int steps) {
    final String key = "%d-%d".formatted(number, steps);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    if (steps == 0) {
      return 1;
    }

    long value = 0;

    if (number == 0) {
      value += getValueAfterSteps(cache, 1L, steps - 1);
    } else {
      final String baseTen = String.valueOf(number);

      if (baseTen.length() % 2 == 0) {
        value +=
            getValueAfterSteps(
                    cache, Long.valueOf(baseTen.substring(0, baseTen.length() / 2)), steps - 1)
                + getValueAfterSteps(
                    cache, Long.valueOf(baseTen.substring(baseTen.length() / 2)), steps - 1);
      } else {
        value += getValueAfterSteps(cache, number * 2024, steps - 1);
      }
    }

    cache.put(key, value);
    return value;
  }
}
