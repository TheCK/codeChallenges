package org.ck.adventofcode.year2021.day14;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Solution(
    id = 20211402,
    name = "Day 14: Extended Polymerization - Part 2",
    url = "https://adventofcode.com/2021/day/14#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    Map<String, Long> pairs = new HashMap<>();
    Map<String, Set<String>> replacements = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      for (int i = 0; i < line.length() - 1; ++i) {
        String pair = "" + line.charAt(i) + line.charAt(i + 1);

        pairs.put(pair, 0L);
        pairs.computeIfPresent(pair, (key, value) -> value + 1);
      }
      in.nextLine();

      while (in.hasNextLine()) {
        final String[] split = in.nextLine().split(" -> ");

        replacements.put(split[0], new HashSet<>());

        replacements.get(split[0]).add(split[0].charAt(0) + split[1]);
        replacements.get(split[0]).add(split[1] + split[0].charAt(1));
      }

      for (int i = 0; i < 40; ++i) {
        pairs = remap(pairs, replacements);
      }

      final Map<String, Long> counts =
          pairs.entrySet().stream()
              .map(entry -> new Count(entry.getKey(), entry.getValue()))
              .flatMap(
                  pairCount ->
                      Stream.of(
                          new Count(pairCount.string().substring(0, 1), pairCount.count()),
                          new Count(pairCount.string().substring(1, 2), pairCount.count())))
              .collect(Collectors.groupingBy(Count::string, Collectors.summingLong(Count::count)));

      counts.computeIfPresent(line.substring(0, 1), (key, value) -> value + 1);
      counts.computeIfPresent(line.substring(line.length() - 1), (key, value) -> value + 1);

      final LongSummaryStatistics longSummaryStatistics =
          counts.values().stream().mapToLong(i -> i).summaryStatistics();

      System.out.println((longSummaryStatistics.getMax() - longSummaryStatistics.getMin()) / 2);
    }
  }

  private static Map<String, Long> remap(
      final Map<String, Long> pairs, final Map<String, Set<String>> replacements) {
    HashMap<String, Long> newPairs = new HashMap<>();

    for (Map.Entry<String, Long> pair : pairs.entrySet()) {
      for (String replacement : replacements.get(pair.getKey())) {
        newPairs.putIfAbsent(replacement, 0L);
        newPairs.computeIfPresent(replacement, (key, value) -> value + pair.getValue());
      }
    }

    return newPairs;
  }

  private static final record Count(String string, long count) {}
}
