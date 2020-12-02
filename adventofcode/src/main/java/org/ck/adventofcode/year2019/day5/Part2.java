package org.ck.adventofcode.year2019.day5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190502,
    name = "Day 5: Sunny with a Chance of Asteroids - Part 2",
    url = "https://adventofcode.com/2019/day/5#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    List<Integer> memory = new ArrayList<>();
    Queue<Integer> inputs = new ArrayDeque<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("[^0-9-]+");
      int numberOfInputs = in.nextInt();

      for (int i = 0; i < numberOfInputs; ++i) {
        inputs.add(in.nextInt());
      }

      while (in.hasNextInt()) {
        memory.add(in.nextInt());
      }
    }

    int i = 0;
    while (memory.get(i) != 99) {
      int opCode = memory.get(i) % 100;
      int mode1 = memory.get(i) % 1000 / 100;
      int mode2 = memory.get(i) % 10000 / 1000;

      switch (opCode) {
        case 1:
          int var11 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));
          int var12 = mode2 == 1 ? memory.get(i + 2) : memory.get(memory.get(i + 2));

          memory.set(memory.get(i + 3), var11 + var12);
          i += 4;
          break;
        case 2:
          int var21 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));
          int var22 = mode2 == 1 ? memory.get(i + 2) : memory.get(memory.get(i + 2));

          memory.set(memory.get(i + 3), var21 * var22);
          i += 4;
          break;
        case 3:
          memory.set(memory.get(i + 1), inputs.remove());
          i += 2;
          break;
        case 4:
          int var4 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));

          System.out.println(var4);
          i += 2;
          break;
        case 5:
          int var51 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));
          int var52 = mode2 == 1 ? memory.get(i + 2) : memory.get(memory.get(i + 2));

          if (var51 != 0) {
            i = var52;
          } else {
            i += 3;
          }
          break;
        case 6:
          int var61 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));
          int var62 = mode2 == 1 ? memory.get(i + 2) : memory.get(memory.get(i + 2));

          if (var61 == 0) {
            i = var62;
          } else {
            i += 3;
          }
          break;
        case 7:
          int var71 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));
          int var72 = mode2 == 1 ? memory.get(i + 2) : memory.get(memory.get(i + 2));

          memory.set(memory.get(i + 3), var71 < var72 ? 1 : 0);
          i += 4;
          break;
        case 8:
          int var81 = mode1 == 1 ? memory.get(i + 1) : memory.get(memory.get(i + 1));
          int var82 = mode2 == 1 ? memory.get(i + 2) : memory.get(memory.get(i + 2));

          memory.set(memory.get(i + 3), var81 == var82 ? 1 : 0);
          i += 4;
          break;
        default:
          throw new RuntimeException("This should not happen");
      }
    }
  }
}
