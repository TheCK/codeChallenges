package org.ck.adventofcode.year2021.day06;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210601,
    name = "Day 6: Lanternfish",
    url = "https://adventofcode.com/2021/day/6",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    List<Integer> fish = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      fish = Arrays.stream(in.nextLine().split(",")).map(Integer::valueOf).collect(toList());
    }

    for (int i = 0; i < 80; ++i) {
      List<Integer> newFish = new ArrayList<>();

      for (int days : fish) {
        if (days == 0) {
          newFish.add(6);
          newFish.add(8);
        } else {
          newFish.add(days - 1);
        }
      }

      fish = newFish;
    }

    System.out.println(fish.size());
  }
}
