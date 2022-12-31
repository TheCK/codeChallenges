package org.ck.adventofcode.year2021.day01;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20210101,
    name = "Day 1: Sonar Sweep",
    url = "https://adventofcode.com/2021/day/1",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    int deeper = 0;
    int last = Integer.MAX_VALUE;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        int current = in.nextInt();

        if (current > last) {
          ++deeper;
        }

        last = current;
      }
    }

    System.out.println(deeper);
  }
}
