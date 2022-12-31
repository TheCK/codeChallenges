package org.ck.adventofcode.year2021.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210102,
    name = "Day 1: Sonar Sweep - Part 2",
    url = "https://adventofcode.com/2021/day/1#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    int deeper = 0;
    List<Integer> lasts = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        lasts.add(in.nextInt());

        if (lasts.size() == 4) {
          if (lasts.get(3) > lasts.get(0)) {
            ++deeper;
          }

          lasts.remove(0);
        }
      }
    }

    System.out.println(deeper);
  }
}
