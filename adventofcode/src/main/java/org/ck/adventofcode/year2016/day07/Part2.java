package org.ck.adventofcode.year2016.day07;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20160702,
    name = "Day 7: Internet Protocol Version 7 - Part 2",
    url = "https://adventofcode.com/2016/day/7#part2",
    category = "2016")
public class Part2 {
  public static void main(String[] args) {
    int valid = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] line = in.nextLine().split("[\\]\\[]");

        List<String> outsides = new ArrayList<>();
        List<String> insides = new ArrayList<>();
        for (int i = 0; i < line.length; ++i) {
          if (i % 2 == 0) {
            outsides.add(line[i]);
          } else {
            insides.add(line[i]);
          }
        }

        if (isValid(outsides, insides)) {
          ++valid;
        }
      }
    }

    System.out.println(valid);
  }

  private static boolean isValid(final List<String> outsides, final List<String> insides) {
    for (String outside : outsides) {
      for (int i = 0; i < outside.length() - 2; ++i) {
        if (outside.charAt(i) == outside.charAt(i + 2)
            && outside.charAt(i) != outside.charAt(i + 1)) {
          for (String inside : insides) {
            for (int j = 0; j < inside.length() - 2; ++j) {
              if (outside.charAt(i) == inside.charAt(j + 1)
                  && outside.charAt(i + 1) == inside.charAt(j)
                  && outside.charAt(i + 1) == inside.charAt(j + 2)) {
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }
}
