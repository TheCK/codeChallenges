package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230701,
    name = "Day 7: Camel Cards",
    url = "https://adventofcode.com/2023/day/7",
    category = "2023")
@Solution(
    id = 20230702,
    name = "Day 7: Camel Cards - Part 2",
    url = "https://adventofcode.com/2023/day/7#part2",
    category = "2023")
public class Day07 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, getToHandFunction(groupedCards -> 0), getRoundComparator('9' + 2));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        getToHandFunction(groupedCards -> (int) (long) groupedCards.getOrDefault("J", 0L)),
        getRoundComparator('0'));
  }

  private Function<String, Hand> getToHandFunction(
      final ToIntFunction<Map<String, Long>> getNumberOfJokers) {
    return cards -> {
      final Map<String, Long> groupedCards =
          Arrays.stream(cards.split(""))
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      final int numberOfJokers = getNumberOfJokers.applyAsInt(groupedCards);
      final long maxCount = groupedCards.values().stream().mapToLong(n -> n).max().orElseThrow();

      return switch (groupedCards.size()) {
        case 1 -> Hand.FIVE;
        case 2 -> getHandForTwoDifferentCardTypes(numberOfJokers, maxCount);
        case 3 -> getHandForThreeDifferentCardTypes(maxCount, numberOfJokers);
        case 4 -> getHandForFourDifferentCardTypes(numberOfJokers);
        case 5 -> getHandForFiveDifferentCardTypes(numberOfJokers);
        default -> throw new IllegalStateException();
      };
    };
  }

  private static Hand getHandForFiveDifferentCardTypes(final int numberOfJokers) {
    return numberOfJokers != 0 ? Hand.PAIR : Hand.HIGH;
  }

  private static Hand getHandForFourDifferentCardTypes(final int numberOfJokers) {
    return numberOfJokers != 0 ? Hand.THREE : Hand.PAIR;
  }

  private static Hand getHandForThreeDifferentCardTypes(
      final long maxCount, final int numberOfJokers) {
    if (maxCount == 3) {
      if (numberOfJokers == 1 || numberOfJokers == 3) {
        return Hand.FOUR;
      }

      return Hand.THREE;
    }

    if (numberOfJokers == 1) {
      return Hand.FULL_HOUSE;
    } else if (numberOfJokers == 2) {
      return Hand.FOUR;
    }

    return Hand.TWO_PAIR;
  }

  private static Hand getHandForTwoDifferentCardTypes(
      final int numberOfJokers, final long maxCount) {
    if (numberOfJokers != 0) {
      return Hand.FIVE;
    }

    return maxCount == 4 ? Hand.FOUR : Hand.FULL_HOUSE;
  }

  private Comparator<Round> getRoundComparator(final int jackValue) {
    return (round1, round2) -> {
      if (round1.hand() != round2.hand()) {
        return round1.hand().compareTo(round2.hand());
      }

      for (int i = 0; i < round1.cards().length(); ++i) {
        final int thisCard = getCardValueMapper(jackValue).applyAsInt(round1.cards().charAt(i));
        final int otherCard = getCardValueMapper(jackValue).applyAsInt(round2.cards().charAt(i));

        if (thisCard != otherCard) {
          return Integer.compare(thisCard, otherCard);
        }
      }

      return 0;
    };
  }

  private ToIntFunction<Character> getCardValueMapper(final int jackValue) {
    return character ->
        switch (character) {
          case 'T' -> '9' + 1;
          case 'J' -> jackValue;
          case 'Q' -> '9' + 3;
          case 'K' -> '9' + 4;
          case 'A' -> '9' + 5;
          default -> character;
        };
  }

  private void run(
      final Scanner in,
      final Function<String, Hand> toHandFunction,
      final Comparator<Round> roundsComparator) {
    final List<Round> rounds = new ArrayList<>();

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(" ");

      rounds.add(new Round(toHandFunction.apply(line[0]), line[0], Long.parseLong(line[1])));
    }

    rounds.sort(roundsComparator);

    long sum = 0;
    for (int i = 0; i < rounds.size(); ++i) {
      sum += (i + 1) * rounds.get(i).bet();
    }

    print(sum);
  }

  private record Round(Hand hand, String cards, long bet) {}

  private enum Hand {
    HIGH,
    PAIR,
    TWO_PAIR,
    THREE,
    FULL_HOUSE,
    FOUR,
    FIVE
  }
}
