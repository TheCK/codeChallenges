package org.ck.adventofcode.year2015.day20;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152002,
    name = "Day 20: Infinite Elves and Infinite Houses - Part 2",
    url = "https://adventofcode.com/2015/day/20#part2",
    category = "2015")
public class Part2 {

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      long presents = in.nextInt();

      long house = 1;
      while (true) {
        if (calculatePresents(house) >= presents) {
          System.out.println(house);
          break;
        }

        ++house;
      }
    }
  }

  private static long calculatePresents(final long house) {
    long presents = 0;
    for (long i = 1; i <= 50; ++i) {
      if (house % i == 0) {
        presents += 11 * (house / i);
      }
    }

    return presents;
  }
}
