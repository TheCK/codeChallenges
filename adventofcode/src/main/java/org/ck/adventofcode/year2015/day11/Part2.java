package org.ck.adventofcode.year2015.day11;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20151102,
    name = "Day 11: Corporate Policy - Part 2",
    url = "https://adventofcode.com/2015/day/11#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      char[] password = in.nextLine().toCharArray();

      while (true) {
        increment(password);

        String candidate = String.copyValueOf(password);
        if (isValid(candidate)) {
          System.out.println(candidate);
          return;
        }
      }
    }
  }

  private static void increment(char[] password) {
    int pos = password.length - 1;

    boolean cont = true;
    while (cont) {
      password[pos]++;
      if (password[pos] > 'z') {
        password[pos] = 'a';
        --pos;
      } else {
        cont = false;
      }
    }
  }

  private static boolean isValid(String candidate) {
    if (candidate.contains("i") || candidate.contains("0") || candidate.contains("l")) {
      return false;
    }

    int doubles = 0;
    int last = ' ';
    for (int i = 0; i < candidate.length(); ++i) {
      if (last == candidate.charAt(i)) {
        ++doubles;
        ++i;
      }

      if (i < candidate.length()) {
        last = candidate.charAt(i);
      }
    }

    boolean hasSequence = false;
    for (int i = 2; i < candidate.length(); ++i) {
      if (candidate.charAt(i) == candidate.charAt(i - 1) + 1
          && candidate.charAt(i - 1) == candidate.charAt(i - 2) + 1) {
        hasSequence = true;
        break;
      }
    }

    return doubles > 1 && hasSequence;
  }
}
