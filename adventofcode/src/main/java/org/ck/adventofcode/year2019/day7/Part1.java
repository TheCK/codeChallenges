package org.ck.adventofcode.year2019.day7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190701,
    name = "Day 7: Amplification Circuit",
    url = "https://adventofcode.com/2019/day/7",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    List<Integer> memory = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("[^0-9-]+");

      while (in.hasNextInt()) {
        memory.add(in.nextInt());
      }
    }

    List<List<Integer>> permutations = getPermutations(Arrays.asList(0, 1, 2, 3, 4));
    int max = Integer.MIN_VALUE;

    for (List<Integer> permutaion : permutations) {
      int input = 0;
      for (int phaseSetting : permutaion) {
        Queue<Integer> inputs = new ArrayDeque<>();
        inputs.add(phaseSetting);
        inputs.add(input);

        input = new Computer(memory).run(inputs).remove();
        max = Math.max(max, input);
      }
    }

    System.out.println(max);
  }

  private static List<List<Integer>> getPermutations(List<Integer> numbers) {
    List<List<Integer>> permutations = new ArrayList<>();

    fillPermutations(numbers, permutations, new ArrayList<>());

    return permutations;
  }

  private static void fillPermutations(
      List<Integer> numbers, List<List<Integer>> permutations, List<Integer> permutation) {
    if (numbers.isEmpty()) {
      permutations.add(permutation);
    }

    for (Integer number : numbers) {
      List<Integer> newNumbers = new ArrayList<>(numbers);
      newNumbers.remove(number);

      List<Integer> newPermutation = new ArrayList<>(permutation);
      newPermutation.add(number);

      fillPermutations(newNumbers, permutations, newPermutation);
    }
  }

  private static class Computer {
    private List<Integer> memory = new ArrayList<>();
    private int memPointer = 0;

    public Computer(List<Integer> memory) {
      this.memory.addAll(memory);
    }

    public Queue<Integer> run(Queue<Integer> inputs) {
      Queue<Integer> outputs = new ArrayDeque<>();

      while (memory.get(memPointer) != 99) {
        int opCode = memory.get(memPointer) % 100;
        int mode1 = memory.get(memPointer) % 1000 / 100;
        int mode2 = memory.get(memPointer) % 10000 / 1000;

        switch (opCode) {
          case 1:
            int var11 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));
            int var12 =
                mode2 == 1 ? memory.get(memPointer + 2) : memory.get(memory.get(memPointer + 2));

            memory.set(memory.get(memPointer + 3), var11 + var12);
            memPointer += 4;
            break;
          case 2:
            int var21 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));
            int var22 =
                mode2 == 1 ? memory.get(memPointer + 2) : memory.get(memory.get(memPointer + 2));

            memory.set(memory.get(memPointer + 3), var21 * var22);
            memPointer += 4;
            break;
          case 3:
            memory.set(memory.get(memPointer + 1), inputs.remove());
            memPointer += 2;
            break;
          case 4:
            int var4 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));

            outputs.add(var4);
            memPointer += 2;
            break;
          case 5:
            int var51 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));
            int var52 =
                mode2 == 1 ? memory.get(memPointer + 2) : memory.get(memory.get(memPointer + 2));

            if (var51 != 0) {
              memPointer = var52;
            } else {
              memPointer += 3;
            }
            break;
          case 6:
            int var61 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));
            int var62 =
                mode2 == 1 ? memory.get(memPointer + 2) : memory.get(memory.get(memPointer + 2));

            if (var61 == 0) {
              memPointer = var62;
            } else {
              memPointer += 3;
            }
            break;
          case 7:
            int var71 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));
            int var72 =
                mode2 == 1 ? memory.get(memPointer + 2) : memory.get(memory.get(memPointer + 2));

            memory.set(memory.get(memPointer + 3), var71 < var72 ? 1 : 0);
            memPointer += 4;
            break;
          case 8:
            int var81 =
                mode1 == 1 ? memory.get(memPointer + 1) : memory.get(memory.get(memPointer + 1));
            int var82 =
                mode2 == 1 ? memory.get(memPointer + 2) : memory.get(memory.get(memPointer + 2));

            memory.set(memory.get(memPointer + 3), var81 == var82 ? 1 : 0);
            memPointer += 4;
            break;
          default:
            throw new RuntimeException("This should not happen");
        }
      }

      return outputs;
    }
  }
}
