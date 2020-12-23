package org.ck.adventofcode.year2020.day22;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20202201,
    name = "Day 22: Crab Combat",
    url = "https://adventofcode.com/2020/day/22",
    category = "2020")
public class Part1 {
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

    while (!deck1.isEmpty() && !deck2.isEmpty()) {
      if (deck1.peek() > deck2.peek()) {
        deck1.add(deck1.remove());
        deck1.add(deck2.remove());
      } else {
        deck2.add(deck2.remove());
        deck2.add(deck1.remove());
      }
    }

    Deque<Integer> winner = deck1.isEmpty() ? deck2 : deck1;

    System.out.println(
        IntStream.range(1, winner.size() + 1).map(index -> index * winner.removeLast()).sum());
  }
}
