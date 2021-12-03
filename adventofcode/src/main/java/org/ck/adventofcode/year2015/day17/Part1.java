package org.ck.adventofcode.year2015.day17;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20151701,
    name = "Day 17: No Such Thing as Too Much",
    url = "https://adventofcode.com/2015/day/17",
    category = "2015")
public class Part1 {

  public static void main(String[] args) throws Exception {
    List<Integer> buckets = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      int amount = in.nextInt();

      while (in.hasNextInt()) {
        buckets.add(in.nextInt());
      }

      System.out.println(count(amount, buckets, 0));
    }
  }

  private static int count(int amount, List<Integer> buckets, int position) {
    if (amount < 0) {
      return 0;
    }

    if (amount == 0) {
      return 1;
    }

    int count = 0;
    for (int i = position; i < buckets.size(); ++i) {

      count += count(amount - buckets.get(i), buckets, i + 1);
    }

    return count;
  }
}
