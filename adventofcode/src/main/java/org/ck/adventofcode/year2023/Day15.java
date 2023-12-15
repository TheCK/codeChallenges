package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.BiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231501,
    name = "Day 15: Lens Library",
    url = "https://adventofcode.com/2023/day/15",
    category = "2023")
@Solution(
    id = 20231502,
    name = "Day 15: Lens Library - Part 2",
    url = "https://adventofcode.com/2023/day/15#part2",
    category = "2023")
public class Day15 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (map, step) -> calculateHash(step), (map, sum) -> sum);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (map, step) -> {
          if (step.contains("=")) {
            final String[] split = step.split("=");
            final int hash = calculateHash(split[0]);

            map.computeIfAbsent(hash, key -> new LinkedHashMap<>());
            map.get(hash).put(split[0], Integer.valueOf(split[1]));
          } else {
            final String name = step.substring(0, step.length() - 1);
            final int hash = calculateHash(name);

            if (map.containsKey(hash)) {
              map.get(hash).remove(name);
            }
          }

          return 0;
        },
        (map, sum) -> {
          long result = 0;

          for (int i = 0; i < 256; ++i) {
            long boxValue = 0;
            long lens = 1;
            for (Map.Entry<String, Integer> boxContents :
                map.getOrDefault(i, Map.of()).entrySet()) {
              boxValue += lens * boxContents.getValue();
              ++lens;
            }

            result += (i + 1) * boxValue;
          }

          return result;
        });
  }

  private void run(
      final Scanner in,
      final BiFunction<Map<Integer, Map<String, Integer>>, String, Integer> stepHandler,
      final BiFunction<Map<Integer, Map<String, Integer>>, Long, Long> resultHandler) {
    final Map<Integer, Map<String, Integer>> map = new HashMap<>();
    long sum = 0;

    final String line = in.nextLine();
    for (final String step : line.split(",")) {
      sum += stepHandler.apply(map, step);
    }

    print(resultHandler.apply(map, sum));
  }

  private static int calculateHash(final String step) {
    int hash = 0;

    for (final char character : step.toCharArray()) {
      hash += character;
      hash *= 17;
      hash %= 256;
    }
    return hash;
  }
}
