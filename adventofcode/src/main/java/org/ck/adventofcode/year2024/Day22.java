package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20242201,
    name = "Day 22: Monkey Market",
    url = "https://adventofcode.com/2024/day/22",
    category = "2024")
@Solution(
    id = 20242202,
    name = "Day 22: Monkey Market - Part 2",
    url = "https://adventofcode.com/2024/day/22#part2",
    category = "2024")
public class Day22 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, secrets -> secrets.stream().mapToLong(List::getLast).sum());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day22::getPart2Result);
  }

  private void run(final Scanner in, final Function<List<List<Long>>, Long> getResult) {
    final List<List<Long>> secrets = new ArrayList<>();

    while (in.hasNextLine()) {
      final List<Long> newSecrets = new ArrayList<>();
      newSecrets.add(Long.parseLong(in.nextLine()));

      for (int i = 0; i < 2000; i++) {
        newSecrets.add(getNextNumber(newSecrets.getLast()));
      }

      secrets.add(newSecrets);
    }

    print(getResult.apply(secrets));
  }

  private long getNextNumber(final long number) {
    long result = ((number * 64) ^ number) % 16777216;
    result = ((result / 32) ^ result) % 16777216;
    result = ((result * 2048) ^ result) % 16777216;

    return result;
  }

  private static long getPart2Result(List<List<Long>> lists) {
    final Map<Sequence, Long> possiblePrices = new HashMap<>();

    for (final List<Long> buyerSecrets : lists) {
      final List<Price> prices = getPrices(buyerSecrets);
      final Set<Sequence> seen = new HashSet<>();

      for (int i = 0; i < prices.size() - 3; i++) {
        final Sequence sequence =
            new Sequence(
                prices.get(i).change(),
                prices.get(i + 1).change(),
                prices.get(i + 2).change(),
                prices.get(i + 3).change());

        if (!seen.contains(sequence)) {
          seen.add(sequence);
          possiblePrices.put(
              sequence, possiblePrices.getOrDefault(sequence, 0L) + prices.get(i + 3).price());
        }
      }
    }

    return possiblePrices.entrySet().stream()
        .max(Comparator.comparingLong(Map.Entry::getValue))
        .orElseThrow()
        .getValue();
  }

  private static List<Price> getPrices(final List<Long> buyerSecrets) {
    final List<Price> prices = new ArrayList<>();

    for (int i = 1; i < buyerSecrets.size(); ++i) {
      prices.add(
          new Price(
              buyerSecrets.get(i) % 10, buyerSecrets.get(i) % 10 - buyerSecrets.get(i - 1) % 10));
    }

    return prices;
  }

  private record Price(long price, long change) {}

  private record Sequence(long one, long two, long three, long four) {}
}
