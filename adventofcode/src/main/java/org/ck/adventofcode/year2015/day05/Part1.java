package org.ck.adventofcode.year2015.day05;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20150501,
    name = "Day 5: Doesn't He Have Intern-Elves For This?",
    url = "https://adventofcode.com/2015/day/5",
    category = "2015")
public class Part1 {
  public static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

  public static void main(String[] args) throws Exception {
    int nice = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        int vowel = 0;
        char last = ' ';
        boolean doubleLetters = false;
        boolean naughtyBits = false;

        for (char letter : line.toCharArray()) {
          if (vowels.contains(letter)) {
            ++vowel;
          }

          if (last == letter) {
            doubleLetters = true;
          }

          if ((last == 'a' && letter == 'b')
              || (last == 'c' && letter == 'd')
              || (last == 'p' && letter == 'q')
              || (last == 'x' && letter == 'y')) {
            naughtyBits = true;
          }

          last = letter;
        }

        if (vowel > 2 && doubleLetters && !naughtyBits) {
          ++nice;
        }
      }
    }

    System.out.println(nice);
  }
}
