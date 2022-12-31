package org.ck.adventofcode.year2021.day14;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Solution(
    id = 20211401,
    name = "Day 14: Extended Polymerization",
    url = "https://adventofcode.com/2021/day/14",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    Map<String, Integer> pairs = new HashMap<>();
    Map<String, Set<String>> replacements = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      for (int i = 0; i < line.length() - 1; ++i) {
        String pair = "" + line.charAt(i) + line.charAt(i + 1);

        pairs.put(pair, 0);
        pairs.computeIfPresent(pair, (key, value) -> value + 1);
      }
      in.nextLine();

      while (in.hasNextLine()) {
        final String[] split = in.nextLine().split(" -> ");

        replacements.put(split[0], new HashSet<>());

        replacements.get(split[0]).add(split[0].charAt(0) + split[1]);
        replacements.get(split[0]).add(split[1] + split[0].charAt(1));
      }

      for (int i = 0; i < 10; ++i) {
        pairs = remap(pairs, replacements);
      }

      final Map<String, Integer> counts =
          pairs.entrySet().stream()
              .map(entry -> new Count(entry.getKey(), entry.getValue()))
              .flatMap(
                  pairCount ->
                      Stream.of(
                          new Count(pairCount.string().substring(0, 1), pairCount.count()),
                          new Count(pairCount.string().substring(1, 2), pairCount.count())))
              .collect(Collectors.groupingBy(Count::string, Collectors.summingInt(Count::count)));

      counts.computeIfPresent(line.substring(0, 1), (key, value) -> value + 1);
      counts.computeIfPresent(line.substring(line.length() - 1), (key, value) -> value + 1);

      final IntSummaryStatistics intSummaryStatistics =
          counts.values().stream().mapToInt(i -> i).summaryStatistics();

      System.out.println((intSummaryStatistics.getMax() - intSummaryStatistics.getMin()) / 2);
    }
  }

  private static Map<String, Integer> remap(
      final Map<String, Integer> pairs, final Map<String, Set<String>> replacements) {
    HashMap<String, Integer> newPairs = new HashMap<>();

    for (Map.Entry<String, Integer> pair : pairs.entrySet()) {
      for (String replacement : replacements.get(pair.getKey())) {
        newPairs.putIfAbsent(replacement, 0);
        newPairs.computeIfPresent(replacement, (key, value) -> value + pair.getValue());
      }
    }

    return newPairs;
  }

  private static final record Count(String string, int count) {}
}
