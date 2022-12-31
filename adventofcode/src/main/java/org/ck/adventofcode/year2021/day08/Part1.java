package org.ck.adventofcode.year2021.day08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210801,
    name = "Day 8: Seven Segment Search",
    url = "https://adventofcode.com/2021/day/8",
    category = "2021")
public class Part1 {
  public static Set<Integer> unique = new HashSet<>(Arrays.asList(2, 3, 4, 7));

  public static void main(String[] args) {
    long sum = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        sum +=
            Arrays.stream(in.nextLine().split(" \\| ")[1].split(" "))
                .filter(value -> unique.contains(value.length()))
                .count();
      }
    }

    System.out.println(sum);
  }
}
