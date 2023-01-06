package org.ck.adventofcode.year2019.day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20190202,
    name = "Day 2: 1202 Program Alarm - Part 2",
    url = "https://adventofcode.com/2019/day/2#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    List<Integer> initialMemory = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("\\D+");
      int expectedResult = in.nextInt();

      while (in.hasNextInt()) {
        initialMemory.add(in.nextInt());
      }

      for (int noun = 0; noun < 100; ++noun) {
        for (int verb = 0; verb < 100; ++verb) {
          List<Integer> memory = new ArrayList<>(initialMemory);

          memory.set(1, noun);
          memory.set(2, verb);

          int i = 0;
          while (memory.get(i) != 99) {
            switch (memory.get(i)) {
              case 1 -> {
                memory.set(
                    memory.get(i + 3),
                    memory.get(memory.get(i + 1)) + memory.get(memory.get(i + 2)));
                i += 4;
              }
              case 2 -> {
                memory.set(
                    memory.get(i + 3),
                    memory.get(memory.get(i + 1)) * memory.get(memory.get(i + 2)));
                i += 4;
              }
              default -> throw new IllegalStateException("This should not happen");
            }
          }

          if (memory.get(0) == expectedResult) {
            System.out.println(100 * noun + verb);
            break;
          }
        }
      }
    }
  }
}
