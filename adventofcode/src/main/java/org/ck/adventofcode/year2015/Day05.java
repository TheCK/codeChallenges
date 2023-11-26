package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.Predicate;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150501,
    name = "Day 5: Doesn't He Have Intern-Elves For This?",
    url = "https://adventofcode.com/2015/day/5",
    category = "2015")
@Solution(
    id = 20150502,
    name = "Day 5: Doesn't He Have Intern-Elves For This? - Part 2",
    url = "https://adventofcode.com/2015/day/5#part2",
    category = "2015")
public class Day05 extends AOCSolution {
  private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
  private static final Set<String> naughtyStrings = Set.of("ab", "cd", "pq", "xy");

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        string -> {
          int vowel = 0;
          boolean doubleLetters = false;

          for (int i = 0; i < string.length(); ++i) {
            final char current = string.charAt(i);

            if (vowels.contains(current)) {
              ++vowel;
            }

            if (i < string.length() - 1) {
              if (current == string.charAt(i + 1)) {
                doubleLetters = true;
              }

              if (naughtyStrings.contains(string.substring(i, i + 2))) {
                return false;
              }
            }
          }

          return vowel > 2 && doubleLetters;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        string -> {
          boolean doublePairs = false;
          boolean oneLetterDistance = false;

          char last = ' ';
          char secondLast = ' ';

          for (char letter : string.toCharArray()) {

            if (secondLast == letter) {
              oneLetterDistance = true;
            }

            secondLast = last;
            last = letter;
          }

          Map<String, List<Integer>> pairs = new HashMap<>();
          for (int i = 0; i < string.length() - 1; ++i) {
            String sub = string.substring(i, i + 2);

            if (pairs.containsKey(sub)) {
              for (int otherIndex : pairs.get(sub)) {
                if (i - otherIndex > 1) {
                  doublePairs = true;
                  break;
                }
              }
            }

            pairs.putIfAbsent(sub, new ArrayList<>());
            pairs.get(sub).add(i);
          }

          return oneLetterDistance && doublePairs;
        });
  }

  private void run(final Scanner in, Predicate<String> isNice) {
    int nice = 0;

    while (in.hasNextLine()) {
      if (isNice.test(in.nextLine())) {
        ++nice;
      }
    }

    print(nice);
  }
}
