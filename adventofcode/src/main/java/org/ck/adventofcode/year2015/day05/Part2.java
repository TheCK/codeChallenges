package org.ck.adventofcode.year2015.day05;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150502,
    name = "Day 5: Doesn't He Have Intern-Elves For This? - Part 2",
    url = "https://adventofcode.com/2015/day/5#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) throws Exception {
    int nice = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        boolean doublePairs = false;
        boolean oneLetterDistance = false;

        char last = ' ';
        char secondLast = ' ';

        for (char letter : line.toCharArray()) {

          if (secondLast == letter) {
            oneLetterDistance = true;
          }

          secondLast = last;
          last = letter;
        }

        Map<String, List<Integer>> pairs = new HashMap<>();
        for (int i = 0; i < line.length() - 1; ++i) {
          String sub = line.substring(i, i + 2);

          if (pairs.containsKey(sub)) {
            for (int otherIndex : pairs.get(sub)) {
              if (i - otherIndex > 1) {
                doublePairs = true;
              }
            }
          }

          pairs.putIfAbsent(sub, new ArrayList<>());
          pairs.get(sub).add(i);
        }

        if (doublePairs && oneLetterDistance) {
          ++nice;
        }
      }
    }

    System.out.println(nice);
  }
}
