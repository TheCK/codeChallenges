package org.ck.adventofcode.year2015;

import java.util.Scanner;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152001,
    name = "Day 20: Infinite Elves and Infinite Houses",
    url = "https://adventofcode.com/2015/day/20",
    category = "2015")
@Solution(
    id = 20152002,
    name = "Day 20: Infinite Elves and Infinite Houses - Part 2",
    url = "https://adventofcode.com/2015/day/20#part2",
    category = "2015")
public class Day20 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        getCalculatePresents(
            house -> (long) Math.sqrt(house), 10, (house, elf) -> elf + (house / elf)));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, getCalculatePresents(house -> 50, 11, (house, elf) -> house / elf));
  }

  private void run(final Scanner in, final LongUnaryOperator calculatePresents) {
    final long presents = in.nextInt();

    long house = 1;
    while (true) {
      if (calculatePresents.applyAsLong(house) >= presents) {
        print(house);
        break;
      }

      ++house;
    }
  }

  private static LongUnaryOperator getCalculatePresents(
      final LongUnaryOperator maxHouses,
      final int presentsPerHouse,
      final LongBinaryOperator getElfValues) {
    return house -> {
      long presents = 0;

      for (long i = 1; i <= maxHouses.applyAsLong(house); ++i) {
        if (house % i == 0) {
          presents += presentsPerHouse * getElfValues.applyAsLong(house, i);
        }
      }

      return presents;
    };
  }
}
