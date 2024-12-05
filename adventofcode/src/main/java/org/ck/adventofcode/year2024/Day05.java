package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.ToIntBiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240501,
    name = "Day 5: Print Queue",
    url = "https://adventofcode.com/2024/day/5",
    category = "2024")
@Solution(
    id = 20240502,
    name = "Day 5: Print Queue - Part 2",
    url = "https://adventofcode.com/2024/day/5#part2",
    category = "2024",
    solved = false)
public class Day05 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (update, orderRules) -> {
          if (isValid(update, orderRules)) {
            return update.get(update.size() / 2);
          }

          return 0;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (update, orderRules) -> {
          if (!isValid(update, orderRules)) {
            while (!isValid(update, orderRules)) {
              break;
            }

            return update.get(update.size() / 2);
          }

          return 0;
        });
  }

  private void run(
      final Scanner in,
      final ToIntBiFunction<List<Integer>, Map<Integer, List<Integer>>> getPageNumber) {
    final Map<Integer, List<Integer>> orderRules = new HashMap<>();
    final List<List<Integer>> updates = new ArrayList<>();

    readInput(in, orderRules, updates);

    int validMiddlePages = 0;
    for (List<Integer> update : updates) {
      validMiddlePages += getPageNumber.applyAsInt(update, orderRules);
    }

    print(validMiddlePages);
  }

  private static void readInput(
      final Scanner in,
      final Map<Integer, List<Integer>> orderRules,
      final List<List<Integer>> updates) {
    while (in.hasNextLine()) {
      final String line = in.nextLine();

      if (line.contains("|")) {
        final String[] parts = line.split("\\|");

        orderRules
            .computeIfAbsent(Integer.valueOf(parts[0]), k -> new ArrayList<>())
            .add(Integer.valueOf(parts[1]));
      } else if (!line.isBlank()) {
        final String[] parts = line.split(",");

        updates.add(Arrays.stream(parts).map(Integer::parseInt).toList());
      }
    }
  }

  private boolean isValid(
      final List<Integer> update, final Map<Integer, List<Integer>> orderRules) {
    Set<Integer> alreadyPrinted = new HashSet<>();

    for (Integer page : update) {
      if (orderRules.containsKey(page)) {
        for (Integer laterPage : orderRules.get(page)) {
          if (alreadyPrinted.contains(laterPage)) {
            return false;
          }
        }
      }

      alreadyPrinted.add(page);
    }

    return true;
  }
}
