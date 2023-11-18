package org.ck.adventofcode.year2017.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170501,
    name = "Day 5: A Maze of Twisty Trampolines, All Alike",
    url = "https://adventofcode.com/2017/day/5",
    category = "2017")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> jumps = new ArrayList<>();

      while (in.hasNextInt()) {
        jumps.add(in.nextInt());
      }

      int pointer = 0;
      int counter = 0;

      while (pointer < jumps.size()) {
        jumps.set(pointer, jumps.get(pointer) + 1);
        pointer = pointer + jumps.get(pointer) - 1;

        ++counter;
      }

      System.out.println(counter);
    }
  }
}
