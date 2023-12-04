package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230401,
    name = "Day 4: Scratchcards",
    url = "https://adventofcode.com/2023/day/4",
    category = "2023")
@Solution(
    id = 20230402,
    name = "Day 4: Scratchcards - Part 2",
    url = "https://adventofcode.com/2023/day/4#part2",
    category = "2023")
public class Day04 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        cards ->
            cards.stream()
                .filter(card -> card.winningNumbersCount() > 0)
                .mapToLong(card -> (long) Math.pow(2, card.winningNumbersCount() - 1.0))
                .sum());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        cards -> {
          final List<Long> cardsCounts = new ArrayList<>(cards.size());
          cards.forEach(card -> cardsCounts.add(1L));

          for (int i = 0; i < cards.size(); ++i) {
            for (int j = i + 1; j < i + 1 + cards.get(i).winningNumbersCount(); ++j) {
              cardsCounts.set(j, cardsCounts.get(j) + cardsCounts.get(i));
            }
          }

          return cardsCounts.stream().mapToLong(n -> n).sum();
        });
  }

  private void run(final Scanner in, final ToLongFunction<List<Card>> getResult) {
    final List<Card> cards = new ArrayList<>();

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split("(:| \\|) +");

      Set<String> winningNumbers = Arrays.stream(line[1].split(" +")).collect(Collectors.toSet());
      Set<String> cardNumbers = Arrays.stream(line[2].split(" +")).collect(Collectors.toSet());

      cardNumbers.retainAll(winningNumbers);

      cards.add(new Card(line[0], cardNumbers.size()));
    }

    print(getResult.applyAsLong(cards));
  }

  private record Card(String name, int winningNumbersCount) {}
}
