package org.ck.adventofcode.year2017.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170601,
    name = "Day 6: Memory Reallocation",
    url = "https://adventofcode.com/2017/day/6",
    category = "2017")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> memory = new ArrayList<>();

      while (in.hasNextInt()) {
        memory.add(in.nextInt());
      }

      List<List<Integer>> history = new ArrayList<>();

      int count = 0;

      while (!history.contains(memory)) {
        history.add(memory);

        List<Integer> newMemory = new ArrayList<>(memory);
        int index = findMaxIndex(newMemory);

        int blocks = newMemory.get(index);
        newMemory.set(index, 0);

        while (blocks > 0) {
          index = (index + 1) % newMemory.size();
          newMemory.set(index, newMemory.get(index) + 1);

          --blocks;
        }

        memory = newMemory;
        ++count;
      }

      System.out.println(count);
    }
  }

  private static int findMaxIndex(final List<Integer> memory) {
    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < memory.size(); ++i) {
      if (max < memory.get(i)) {
        max = memory.get(i);
        maxIndex = i;
      }
    }

    return maxIndex;
  }
}
