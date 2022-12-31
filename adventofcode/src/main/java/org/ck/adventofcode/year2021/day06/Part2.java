package org.ck.adventofcode.year2021.day06;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20210602,
    name = "Day 6: Lanternfish - Part 2",
    url = "https://adventofcode.com/2021/day/6#part2",
    category = "2021")
public class Part2 {
  private static final Map<String, Long> cache = new HashMap<>();

  public static void main(String[] args) {
    List<Integer> fish;

    try (Scanner in = new Scanner(System.in)) {
      fish = Arrays.stream(in.nextLine().split(",")).map(Integer::valueOf).toList();
    }

    long numberOfFish = 0;
    for (int number : fish) {
      numberOfFish += calculate(number, 256);
    }

    System.out.println(numberOfFish);
  }

  private static long calculate(final int number, int days) {
    if (days < 0) {
      return 0;
    }

    String key = String.format("%d-%d", number, days);

    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    long sum = 0;
    sum += 1L;

    days = days - number - 1;
    while (days >= 0) {
      sum += calculate(8, days);
      days -= 7;
    }

    cache.put(key, sum);
    return sum;
  }
}
