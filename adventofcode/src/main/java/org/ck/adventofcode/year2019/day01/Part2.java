package org.ck.adventofcode.year2019.day01;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20190102,
    name = "Day 1: The Tyranny of the Rocket Equation - Part 2",
    url = "https://adventofcode.com/2019/day/1#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    int fuel = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        int moduleWeight = in.nextInt();

        int moduleFuel = (moduleWeight / 3) - 2;
        fuel += moduleFuel;

        int extraFuelNeeded = (moduleFuel / 3) - 2;
        while (extraFuelNeeded > 0) {
          fuel += extraFuelNeeded;
          extraFuelNeeded = (extraFuelNeeded / 3) - 2;
        }
      }
    }

    System.out.println(fuel);
  }
}
