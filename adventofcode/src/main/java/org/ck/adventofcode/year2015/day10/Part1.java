package org.ck.adventofcode.year2015.day10;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20151001,
    name = "Day 10: Elves Look, Elves Say",
    url = "https://adventofcode.com/2015/day/10",
    category = "2015")
public class Part1 {
  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String line = String.valueOf(in.nextInt());
      int rounds = in.nextInt();

      for (int i = 0; i < rounds; ++i) {
        StringBuilder newLine = new StringBuilder();

        char current = ' ';
        int count = 0;

        for (int j = 0; j < line.length(); ++j) {
          if (line.charAt(j) != current) {
            if (count > 0) {
              newLine.append(count);
              newLine.append(current);
            }

            current = line.charAt(j);
            count = 1;
          } else {
            ++count;
          }
        }

        if (count > 0) {
          newLine.append(count);
          newLine.append(current);
        }

        line = newLine.toString();
      }

      System.out.println(line.length());
    }
  }
}
