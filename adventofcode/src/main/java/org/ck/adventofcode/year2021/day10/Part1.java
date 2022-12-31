package org.ck.adventofcode.year2021.day10;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20211001,
    name = "Day 10: Syntax Scoring",
    url = "https://adventofcode.com/2021/day/10",
    category = "2021")
public class Part1 {
  private static final Map<Character, Character> pairs =
      new HashMap<>() {
        {
          put('(', ')');
          put('[', ']');
          put('{', '}');
          put('<', '>');
        }
      };

  private static final Map<Character, Integer> values =
      new HashMap<>() {
        {
          put(')', 3);
          put(']', 57);
          put('}', 1197);
          put('>', 25137);
        }
      };

  public static void main(String[] args) {
    int points = 0;
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : in.nextLine().toCharArray()) {
          if (pairs.containsKey(c)) {
            stack.push(pairs.get(c));
          } else {
            if (stack.pop() != c) {
              points += values.get(c);
            }
          }
        }
      }
    }

    System.out.println(points);
  }
}
