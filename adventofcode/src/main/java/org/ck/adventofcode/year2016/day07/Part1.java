package org.ck.adventofcode.year2016.day07;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20160701,
    name = "Day 7: Internet Protocol Version 7",
    url = "https://adventofcode.com/2016/day/7",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    int valid = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] line = in.nextLine().split("[\\]\\[]");

        boolean outside = false;
        boolean inside = false;

        for (int i = 0; i < line.length; ++i) {
          for (int j = 0; j < line[i].length() - 3; ++j) {
            if (line[i].charAt(j) != line[i].charAt(j + 1)
                && line[i].charAt(j) == line[i].charAt(j + 3)
                && line[i].charAt(j + 1) == line[i].charAt(j + 2)) {
              if (i % 2 == 0) {
                outside = true;
              } else {
                inside = true;
              }
            }
          }
        }

        if (outside && !inside) {
          ++valid;
        }
      }
    }

    System.out.println(valid);
  }
}
