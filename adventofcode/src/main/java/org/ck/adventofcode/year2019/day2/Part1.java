package org.ck.adventofcode.year2019.day2;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20190201,
    name = "Day 2: 1202 Program Alarm",
    url = "https://adventofcode.com/2019/day/2",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    List<Integer> memory = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("\\D+");
      while (in.hasNextInt()) {
        memory.add(in.nextInt());
      }
    }

    memory.set(1, 12);
    memory.set(2, 2);

    int i = 0;
    while (memory.get(i) != 99) {
      switch (memory.get(i)) {
        case 1:
          memory.set(
              memory.get(i + 3), memory.get(memory.get(i + 1)) + memory.get(memory.get(i + 2)));
          i += 4;
          break;
        case 2:
          memory.set(
              memory.get(i + 3), memory.get(memory.get(i + 1)) * memory.get(memory.get(i + 2)));
          i += 4;
          break;
        default:
          throw new RuntimeException("This should not happen");
      }
    }

    System.out.println(memory.get(0));
  }
}
