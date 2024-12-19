package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241901,
    name = "Day 19: Linen Layout",
    url = "https://adventofcode.com/2024/day/19",
    category = "2024")
@Solution(
    id = 20241902,
    name = "Day 19: Linen Layout - Part 2",
    url = "https://adventofcode.com/2024/day/19#part2",
    category = "2024")
public class Day19 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, possibilites -> possibilites != 0 ? 1 : 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, LongUnaryOperator.identity());
  }

  private void run(final Scanner in, final LongUnaryOperator getTowelValue) {
    final Set<String> patterns =
        Arrays.stream(in.nextLine().split(", ")).collect(Collectors.toSet());
    in.nextLine();

    final List<String> wantedTowels = new ArrayList<>();
    while (in.hasNextLine()) {
      wantedTowels.add(in.nextLine());
    }

    final Map<String, Long> cache = new HashMap<>();
    long valid = 0;
    for (final String wantedTowel : wantedTowels) {
      valid += getTowelValue.applyAsLong(getPossibleTowerCounts(wantedTowel, patterns, cache));
    }

    print(valid);
  }

  private long getPossibleTowerCounts(
      final String wantedTowel, final Set<String> patterns, final Map<String, Long> cache) {
    if (wantedTowel.isEmpty()) {
      return 1;
    }

    if (cache.containsKey(wantedTowel)) {
      return cache.get(wantedTowel);
    }

    long valid = 0;
    for (String pattern : patterns) {
      if (wantedTowel.startsWith(pattern)) {
        valid += getPossibleTowerCounts(wantedTowel.substring(pattern.length()), patterns, cache);
      }
    }

    cache.put(wantedTowel, valid);

    return valid;
  }
}
