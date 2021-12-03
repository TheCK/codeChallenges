package org.ck.adventofcode.year2015.day20;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20152001,
    name = "Day 20: Infinite Elves and Infinite Houses",
    url = "https://adventofcode.com/2015/day/20",
    category = "2015")
public class Part1 {

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int presents = in.nextInt();

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

  private static int calculatePresents(final long house) {
    int presents = 0;

    for (int i = 1; i <= Math.sqrt(house); ++i) {
      if (house % i == 0) {
        presents += 10 * (i + (house / i));
      }
    }

    return presents;
  }
}
