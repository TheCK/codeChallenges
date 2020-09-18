package org.ck.projecteuler.solutions.problem054;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 54,
    name = "Poker hands",
    url = "https://projecteuler.net/problem=54",
    category = "Problems 51 - 100")
public class Problem {

  private enum Suit {
    UNKNOWN('U'),
    SPADES('S'),
    HEARTS('H'),
    DIAMONDS('D'),
    CLUBS('C');

    private char value;

    Suit(char value) {
      this.value = value;
    }

    public char getValue() {
      return value;
    }
  }

  private enum Value {
    UNKNOWN('U'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private char value;

    Value(char value) {
      this.value = value;
    }

    public char getValue() {
      return value;
    }
  }

  private static class Card {
    private Suit suit = null;
    private Value value = null;

    public Card(String card) {
      char[] values = card.toCharArray();

      setValue(values[0]);
      setSuit(values[1]);
    }

    private void setValue(char valueForValue) {
      setValue(
          Arrays.stream(Value.values())
              .filter(candidate -> candidate.getValue() == valueForValue)
              .findFirst()
              .orElse(Value.UNKNOWN));
    }

    private void setSuit(char valueForSuit) {
      setSuit(
          Arrays.stream(Suit.values())
              .filter(candidate -> candidate.getValue() == valueForSuit)
              .findFirst()
              .orElse(Suit.UNKNOWN));
    }

    public Suit getSuit() {
      return this.suit;
    }

    public void setSuit(Suit suit) {
      this.suit = suit;
    }

    public Value getValue() {
      return this.value;
    }

    public void setValue(Value value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
  }

  private static class Hand implements Comparable<Hand> {
    List<Card> cards;

    public Hand(List<Card> cards) {
      this.cards = cards;
    }

    @Override
    public int compareTo(Hand o) {
      if (isRoyalFlush(cards) && !isRoyalFlush(o.cards)) {
        return 1;
      }
      if (!isRoyalFlush(cards) && isRoyalFlush(o.cards)) {
        return -1;
      }
      if (isRoyalFlush(cards) && isRoyalFlush(o.cards)) {
        return 0;
      }

      if (isStraightFlush(cards) && !isStraightFlush(o.cards)) {
        return 1;
      }
      if (!isStraightFlush(cards) && isStraightFlush(o.cards)) {
        return -1;
      }
      if (isStraightFlush(cards) && isStraightFlush(o.cards)) {
        return getHighCardValueByCards(cards).compareTo(getHighCardValueByCards(o.cards));
      }

      Map<Integer, List<Value>> groupByCount = groupByCount(cards);
      Map<Integer, List<Value>> oGroupByCount = groupByCount(o.cards);

      if (groupByCount.containsKey(4) && !oGroupByCount.containsKey(4)) {
        return 1;
      }
      if (!groupByCount.containsKey(4) && oGroupByCount.containsKey(4)) {
        return -1;
      }
      if (groupByCount.containsKey(4) && oGroupByCount.containsKey(4)) {
        Value highCard4 = getHighCardValueByValues(groupByCount.get(4));
        Value oHighCard4 = getHighCardValueByValues(oGroupByCount.get(4));

        if (highCard4.compareTo(oHighCard4) != 0) {
          return highCard4.compareTo(oHighCard4);
        }

        return compareByHighestUnique(groupByCount.get(1), oGroupByCount.get(1));
      }

      if ((groupByCount.containsKey(3) && groupByCount.containsKey(2))
          && !(oGroupByCount.containsKey(3) && oGroupByCount.containsKey(2))) {
        return 1;
      }
      if (!(groupByCount.containsKey(3) && groupByCount.containsKey(2))
          && (oGroupByCount.containsKey(3) && oGroupByCount.containsKey(2))) {
        return -1;
      }
      if ((groupByCount.containsKey(3) && groupByCount.containsKey(2))
          && (oGroupByCount.containsKey(3) && oGroupByCount.containsKey(2))) {
        Value highCard3 = getHighCardValueByValues(groupByCount.get(3));
        Value oHighCard3 = getHighCardValueByValues(oGroupByCount.get(3));

        if (highCard3.compareTo(oHighCard3) != 0) {
          return highCard3.compareTo(oHighCard3);
        }

        Value highCard2 = getHighCardValueByValues(groupByCount.get(2));
        Value oHighCard2 = getHighCardValueByValues(oGroupByCount.get(2));

        return highCard2.compareTo(oHighCard2);
      }

      if (isFlush(cards) && !isFlush(o.cards)) {
        return 1;
      }
      if (!isFlush(cards) && isFlush(o.cards)) {
        return -1;
      }
      if (isFlush(cards) && isFlush(o.cards)) {
        return compareByHighestUnique(
            cards.stream().map(Card::getValue).collect(Collectors.toList()),
            o.cards.stream().map(Card::getValue).collect(Collectors.toList()));
      }

      if (isStraight(cards) && !isStraight(o.cards)) {
        return 1;
      }
      if (!isStraight(cards) && isStraight(o.cards)) {
        return -1;
      }
      if (isStraight(cards) && isStraight(o.cards)) {
        return getHighCardValueByCards(cards).compareTo(getHighCardValueByCards(o.cards));
      }

      if (groupByCount.containsKey(3) && !oGroupByCount.containsKey(3)) {
        return 1;
      }
      if (!groupByCount.containsKey(3) && oGroupByCount.containsKey(3)) {
        return -1;
      }
      if (groupByCount.containsKey(3) && oGroupByCount.containsKey(3)) {
        return compareByHighestUnique(groupByCount.get(1), oGroupByCount.get(1));
      }

      if (groupByCount.containsKey(2) && !oGroupByCount.containsKey(2)) {
        return 1;
      }
      if (!groupByCount.containsKey(2) && oGroupByCount.containsKey(2)) {
        return -1;
      }
      if (groupByCount.containsKey(2) && oGroupByCount.containsKey(2)) {
        List<Value> pairs = groupByCount.get(2);
        List<Value> oPairs = oGroupByCount.get(2);

        if (pairs.size() != oPairs.size()) {
          return Integer.compare(pairs.size(), oPairs.size());
        }

        if (getHighCardValueByValues(pairs).compareTo(getHighCardValueByValues(oPairs)) != 0) {
          return getHighCardValueByValues(pairs).compareTo(getHighCardValueByValues(oPairs));
        }

        if (getLowCardValueByValues(pairs).compareTo(getLowCardValueByValues(oPairs)) != 0) {
          return getLowCardValueByValues(pairs).compareTo(getLowCardValueByValues(oPairs));
        }

        return compareByHighestUnique(groupByCount.get(1), oGroupByCount.get(1));
      }

      return compareByHighestUnique(groupByCount.get(1), oGroupByCount.get(1));
    }

    private int compareByHighestUnique(List<Value> values, List<Value> oValues) {
      while (!values.isEmpty()) {
        Value highValue = getHighCardValueByValues(values);
        Value oHighValue = getHighCardValueByValues(oValues);

        if (highValue.compareTo(oHighValue) != 0) {
          return highValue.compareTo(oHighValue);
        }

        values.remove(highValue);
        values.remove(oHighValue);
      }

      return 0;
    }

    private Map<Integer, List<Value>> groupByCount(List<Card> cards) {
      Map<Value, List<Card>> groupByValue =
          cards.stream().collect(Collectors.groupingBy(Card::getValue));

      Map<Integer, List<Value>> groupByCount = new HashMap<>();
      for (Map.Entry<Value, List<Card>> gbV : groupByValue.entrySet()) {
        int count = gbV.getValue().size();
        if (!groupByCount.containsKey(count)) {
          groupByCount.put(count, new ArrayList<>());
        }

        groupByCount.get(count).add(gbV.getKey());
      }

      return groupByCount;
    }

    private Value getHighCardValueByCards(List<Card> cards) {
      return getHighCardValueByValues(
          cards.stream().map(Card::getValue).collect(Collectors.toList()));
    }

    private Value getHighCardValueByValues(List<Value> values) {
      return values.stream().max(Comparator.comparing(value -> value)).orElse(Value.UNKNOWN);
    }

    private Value getLowCardValueByValues(List<Value> values) {
      return values.stream().min(Comparator.comparing(value -> value)).orElse(Value.UNKNOWN);
    }

    private boolean isRoyalFlush(List<Card> cards) {
      return isFlush(cards) && isStraight(cards) && getHighCardValueByCards(cards) == Value.ACE;
    }

    private boolean isStraightFlush(List<Card> cards) {
      return isFlush(cards) && isStraight(cards);
    }

    private boolean isStraight(List<Card> cards) {
      IntSummaryStatistics intSummaryStatistics =
          cards.stream().mapToInt(card -> card.getValue().ordinal()).summaryStatistics();

      return cards.stream().map(Card::getValue).distinct().count() == cards.size()
          && intSummaryStatistics.getMax() - intSummaryStatistics.getMin() == cards.size() - 1;
    }

    private boolean isFlush(List<Card> cards) {
      return cards.stream().map(Card::getSuit).distinct().count() == 1;
    }

    @Override
    public String toString() {
      return reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
  }

  public static void main(String[] args) {

    try (Scanner in = new Scanner(System.in)) {
      int p1Wins = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        Hand handP1 =
            new Hand(
                Arrays.stream(Arrays.copyOfRange(line, 0, 5))
                    .map(Card::new)
                    .collect(Collectors.toList()));

        Hand handP2 =
            new Hand(
                Arrays.stream(Arrays.copyOfRange(line, 5, 10))
                    .map(Card::new)
                    .collect(Collectors.toList()));

        if (handP1.compareTo(handP2) > 0) {
          ++p1Wins;
        }
      }

      System.out.println(p1Wins);
    }
  }
}
