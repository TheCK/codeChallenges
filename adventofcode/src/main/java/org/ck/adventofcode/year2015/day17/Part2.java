package org.ck.adventofcode.year2015.day17;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20151702,
    name = "Day 17: No Such Thing as Too Much - Part 2",
    url = "https://adventofcode.com/2015/day/17#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) throws Exception {
    List<Integer> buckets = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      int amount = in.nextInt();

      while (in.hasNextInt()) {
        buckets.add(in.nextInt());
      }

      Map<Integer, Integer> combinationsPerAmount = new HashMap<>();
      count(amount, buckets, 0, 0, combinationsPerAmount);

      combinationsPerAmount.entrySet().stream()
          .min(Comparator.comparingInt(Map.Entry::getKey))
          .ifPresent(item -> System.out.println(item.getValue()));
    }
  }

  private static void count(
      int amount,
      List<Integer> buckets,
      int position,
      int container,
      Map<Integer, Integer> cominationsPerAmount) {
    if (amount < 0) {
      return;
    }

    if (amount == 0) {
      cominationsPerAmount.putIfAbsent(container, 0);
      cominationsPerAmount.put(container, cominationsPerAmount.get(container) + 1);
      return;
    }

    for (int i = position; i < buckets.size(); ++i) {

      count(amount - buckets.get(i), buckets, i + 1, container + 1, cominationsPerAmount);
    }

    return;
  }
}
