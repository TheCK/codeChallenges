package org.ck.adventofcode.year2020.day22;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20202202,
    name = "Day 22: Crab Combat - Part 2",
    url = "https://adventofcode.com/2020/day/22",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    Deque<Integer> deck1 = new ArrayDeque<>();
    Deque<Integer> deck2 = new ArrayDeque<>();

    try (Scanner in = new Scanner(System.in)) {
      in.nextLine();
      while (true) {
        String line = in.nextLine();
        if (line.isBlank()) {
          break;
        }

        deck1.add(Integer.valueOf(line));
      }

      in.nextLine();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        deck2.add(Integer.valueOf(line));
      }
    }

    int winner = playGame(deck1, deck2);
    Deque<Integer> winningDeck = winner == 2 ? deck2 : deck1;

    System.out.println(
        IntStream.range(1, winningDeck.size() + 1)
            .map(index -> index * winningDeck.removeLast())
            .sum());
  }

  private static int playGame(Deque<Integer> deck1, Deque<Integer> deck2) {
    Set<String> previousDecks = new HashSet<>();

    while (!deck1.isEmpty() && !deck2.isEmpty()) {
      String deckString = String.format("%s-%s", deck1, deck2);
      if (previousDecks.contains(deckString)) {
        return 1;
      }

      previousDecks.add(deckString);

      int roundWinner;
      if (deck1.peek() <= deck1.size() - 1 && deck2.peek() <= deck2.size() - 1) {
        Deque<Integer> newDeck1 =
            deck1.stream()
                .skip(1)
                .limit(deck1.peek())
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> newDeck2 =
            deck2.stream()
                .skip(1)
                .limit(deck2.peek())
                .collect(Collectors.toCollection(ArrayDeque::new));

        roundWinner = playGame(newDeck1, newDeck2);
      } else {
        roundWinner = deck1.peek() > deck2.peek() ? 1 : 2;
      }

      if (roundWinner == 1) {
        deck1.add(deck1.remove());
        deck1.add(deck2.remove());
      } else {
        deck2.add(deck2.remove());
        deck2.add(deck1.remove());
      }
    }

    return deck1.isEmpty() ? 2 : 1;
  }
}
