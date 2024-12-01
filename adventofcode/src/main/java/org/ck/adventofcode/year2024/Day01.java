package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240101,
    name = "Day 1: Historian Hysteria",
    url = "https://adventofcode.com/2024/day/1",
    category = "2024")
@Solution(
    id = 20240102,
    name = "Day 1: Historian Hysteria - Part 2",
    url = "https://adventofcode.com/2024/day/1#part2",
    category = "2024")
public class Day01 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (one, two) -> {
          Collections.sort(one);
          Collections.sort(two);

          return i -> Math.abs(one.get(i) - two.get(i));
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (one, two) -> {
          final Map<Integer, Long> collect =
              two.stream()
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

          return i -> collect.containsKey(one.get(i)) ? collect.get(one.get(i)) * one.get(i) : 0;
        });
  }

  private void run(
      final Scanner in,
      final BiFunction<List<Integer>, List<Integer>, IntToLongFunction> getValueGenerator) {
    final List<Integer> one = new ArrayList<>();
    final List<Integer> two = new ArrayList<>();

    while (in.hasNextLine()) {
      final String[] split = in.nextLine().split(" +");

      one.add(Integer.valueOf(split[0]));
      two.add(Integer.valueOf(split[1]));
    }

    final IntToLongFunction valueGenerator = getValueGenerator.apply(one, two);
    print(IntStream.range(0, one.size()).mapToLong(valueGenerator).sum());
  }
}
