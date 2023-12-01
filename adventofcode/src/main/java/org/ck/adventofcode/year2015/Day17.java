package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.ToIntFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151701,
    name = "Day 17: No Such Thing as Too Much",
    url = "https://adventofcode.com/2015/day/17",
    category = "2015")
@Solution(
    id = 20151702,
    name = "Day 17: No Such Thing as Too Much - Part 2",
    url = "https://adventofcode.com/2015/day/17#part2",
    category = "2015")
public class Day17 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, combinations -> combinations.values().stream().mapToInt(n -> n).sum());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        combinations ->
            combinations.entrySet().stream()
                .min(Comparator.comparingInt(Map.Entry::getKey))
                .orElseThrow()
                .getValue());
  }

  private void run(final Scanner in, final ToIntFunction<Map<Integer, Integer>> getResult) {
    final List<Integer> buckets = new ArrayList<>();

    final int amount = in.nextInt();

    while (in.hasNextInt()) {
      buckets.add(in.nextInt());
    }

    final Map<Integer, Integer> combinationsPerAmount = new HashMap<>();
    count(amount, buckets, 0, 0, combinationsPerAmount);

    print(getResult.applyAsInt(combinationsPerAmount));
  }

  private static void count(
      int amount,
      List<Integer> buckets,
      int position,
      int container,
      Map<Integer, Integer> cominationsPerAmount) {
    if (amount < 0) {
      return;
    }

    if (amount == 0) {
      cominationsPerAmount.putIfAbsent(container, 0);
      cominationsPerAmount.put(container, cominationsPerAmount.get(container) + 1);
      return;
    }

    for (int i = position; i < buckets.size(); ++i) {

      count(amount - buckets.get(i), buckets, i + 1, container + 1, cominationsPerAmount);
    }
  }
}
