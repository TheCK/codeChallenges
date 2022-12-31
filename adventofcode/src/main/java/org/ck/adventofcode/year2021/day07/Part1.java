package org.ck.adventofcode.year2021.day07;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

@Solution(
    id = 20210701,
    name = "Day 7: The Treachery of Whales",
    url = "https://adventofcode.com/2021/day/7",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    List<Integer> crabs;

    try (Scanner in = new Scanner(System.in)) {
      crabs = Arrays.stream(in.nextLine().split(",")).map(Integer::valueOf).collect(toList());
    }

    int fuel = Integer.MAX_VALUE;
    IntSummaryStatistics intSummaryStatistics = crabs.stream().mapToInt(x -> x).summaryStatistics();

    for (int i = intSummaryStatistics.getMin(); i <= intSummaryStatistics.getMax(); ++i) {
      int finalI = i;
      int sum = crabs.stream().mapToInt(x -> Math.abs(x - finalI)).sum();
      fuel = Math.min(fuel, sum);
    }

    System.out.println(fuel);
  }
}
