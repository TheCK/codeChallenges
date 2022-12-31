package org.ck.adventofcode.year2022.day03;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Solution(
    id = 20220301,
    name = "Day 3: Rucksack Reorganization",
    url = "https://adventofcode.com/2022/day/3",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int priority = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        String compartment1 = line.substring(0, line.length() / 2);
        String compartment2 = line.substring(line.length() / 2);

        final Set<Integer> items1 = compartment1.chars().boxed().collect(Collectors.toSet());
        final Set<Integer> items2 = compartment2.chars().boxed().collect(Collectors.toSet());

        items1.retainAll(items2);

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
