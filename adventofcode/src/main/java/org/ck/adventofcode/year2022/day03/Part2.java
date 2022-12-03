package org.ck.adventofcode.year2022.day03;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Solution(
    id = 20220302,
    name = "Day 3: ??? - Part 2",
    url = "https://adventofcode.com/2022/day/3#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int priority = 0;

      while (in.hasNextLine()) {
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();

        final Set<Integer> items1 = line1.chars().boxed().collect(Collectors.toSet());
        final Set<Integer> items2 = line2.chars().boxed().collect(Collectors.toSet());
        final Set<Integer> items3 = line3.chars().boxed().collect(Collectors.toSet());

        items1.retainAll(items2);
        items1.retainAll(items3);

        int item = items1.stream().findFirst().get();
        if (Character.isUpperCase(item)) {
          priority += item - 'A' + 27;
        } else {
          priority += item - 'a' + 1;
        }
      }

      System.out.println(priority);
    }
  }
}
