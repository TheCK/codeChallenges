package org.ck.adventofcode.year2021.day03;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20210301,
    name = "Day 3: Binary Diagnostic",
    url = "https://adventofcode.com/2021/day/3",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    int ones[] = null;
    int count = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        ++count;

        if (ones == null) {
          ones = new int[line.length()];
        }

        for (int i = 0; i < line.length(); ++i) {
          if (line.charAt(i) == '1') {
            ++ones[i];
          }
        }
      }
    }

    int gamma = 0;
    int epsilon = 0;

    for (int i = 0; i < ones.length; ++i) {
      if (ones[i] > (count / 2)) {
        gamma |= 1 << (ones.length - i - 1);
      } else {
        epsilon |= 1 << (ones.length - i - 1);
      }
    }

    System.out.println(gamma * epsilon);
  }
}
