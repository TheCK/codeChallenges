package org.ck.adventofcode.year2021.day10;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20211002,
    name = "Day 10: Syntax Scoring - Part 2",
    url = "https://adventofcode.com/2021/day/10#part2",
    category = "2021")
public class Part2 {
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
          put(')', 1);
          put(']', 2);
          put('}', 3);
          put('>', 4);
        }
      };

  public static void main(String[] args) {
    List<Long> points = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : in.nextLine().toCharArray()) {
          if (pairs.containsKey(c)) {
            stack.push(pairs.get(c));
          } else {
            if (stack.pop() != c) {
              while (!stack.isEmpty()) {
                stack.pop();
              }
              break;
            }
          }
        }

        if (!stack.isEmpty()) {
          long score = 0;
          while (!stack.isEmpty()) {
            score *= 5;
            score += values.get(stack.pop());
          }
          points.add(score);
        }
      }
    }

    Collections.sort(points);
    System.out.println(points.get(points.size() / 2));
  }
}
