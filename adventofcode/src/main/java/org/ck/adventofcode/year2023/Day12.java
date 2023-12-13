package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231201,
    name = "Day 12: Hot Springs",
    url = "https://adventofcode.com/2023/day/12",
    category = "2023")
@Solution(
    id = 20231202,
    name = "Day 12: Hot Springs - Part 2",
    url = "https://adventofcode.com/2023/day/12#part2",
    category = "2023")
public class Day12 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, line -> line.split(" "));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        line -> {
          final String[] parts = line.split(" ");

          return new String[] {
            String.join("?", Collections.nCopies(5, parts[0])),
            String.join(",", Collections.nCopies(5, parts[1]))
          };
        });
  }

  private void run(final Scanner in, final Function<String, String[]> getInput) {
    long sum = 0;

    while (in.hasNextLine()) {
      final String[] line = getInput.apply(in.nextLine());
      final List<Integer> damagedLengths =
          Arrays.stream(line[1].split(",")).map(Integer::valueOf).toList();
      final Map<String, Long> cache = new HashMap<>();

      sum += getCombinations(cache, line[0], 0, damagedLengths, 0);
    }

    print(sum);
  }

  private long getCombinations(
      final Map<String, Long> cache,
      final String line,
      final int stringIndex,
      final List<Integer> numbers,
      final int numberIndex) {
    final String cacheKey = "%s-%d".formatted(line, numberIndex);

    if (cache.containsKey(cacheKey)) {
      return cache.get(cacheKey);
    }

    long counts = 0;

    if (numberIndex >= numbers.size()) {
      if (!line.contains("#")) {
        return 1;
      }

      return 0;
    }

    final int number = numbers.get(numberIndex);

    if (stringIndex + number > line.length()) {
      return 0;
    }

    for (int i = stringIndex; i < line.length(); ++i) {
      if (!line.substring(0, i).contains("#")
          && line.length() >= i + number
          && line.substring(i, i + number).matches("[#\\?]{%d}".formatted(number))
          && (i + number == line.length() || line.charAt(i + number) != '#')) {
        counts +=
            getCombinations(
                cache,
                ("X".repeat(i + number + 1)
                        + line.substring(Math.min(i + number + 1, line.length())))
                    .substring(0, line.length()),
                i + number + 1,
                numbers,
                numberIndex + 1);
      }
    }

    cache.put(cacheKey, counts);
    return counts;
  }
}
