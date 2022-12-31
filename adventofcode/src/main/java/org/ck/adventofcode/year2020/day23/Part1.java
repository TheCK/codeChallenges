package org.ck.adventofcode.year2020.day23;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Solution(
    id = 20202301,
    name = "Day 23: Crab Cups",
    url = "https://adventofcode.com/2020/day/23",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int rounds = Integer.parseInt(in.nextLine());

      List<Integer> cups =
          Arrays.stream(in.nextLine().split("")).map(Integer::valueOf).collect(Collectors.toList());

      int active = 0;
      for (int i = 0; i < rounds; ++i) {
        int number = cups.get(active);
        Stack<Integer> removed = new Stack<>();

        for (int j = 0; j < 3; ++j) {
          int removeFrom = (active + 1) % cups.size();
          if (removeFrom <= active) {
            --active;
          }
          removed.push(cups.remove(removeFrom));
        }

        int target = number - 1;
        while (!cups.contains(target)) {
          --target;
          if (target <= 0) {
            target = cups.stream().mapToInt(x -> x).max().getAsInt();
          }
        }

        for (int j = 0; j < 3; ++j) {
          int insertAt = cups.indexOf(target) + 1;
          cups.add(insertAt, removed.pop());
          if (insertAt <= active) {
            ++active;
          }
        }

        active = (active + 1) % cups.size();
      }

      int start = cups.indexOf(1);
      System.out.println(
          IntStream.range(start + 1, start + cups.size())
              .map(index -> cups.get(index % cups.size()))
              .mapToObj(String::valueOf)
              .collect(Collectors.joining()));
    }
  }
}
