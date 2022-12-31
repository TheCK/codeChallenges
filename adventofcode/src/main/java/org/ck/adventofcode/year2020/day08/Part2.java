package org.ck.adventofcode.year2020.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200802,
    name = "Day 8: Handheld Halting - Part 2",
    url = "https://adventofcode.com/2020/day/8#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<String> originalCommands = new ArrayList<>();
      while (in.hasNextLine()) {
        originalCommands.add(in.nextLine());
      }

      boolean terminated = false;
      int instructionToReplace = 0;
      while (!terminated) {
        List<String> commands = new ArrayList<>(originalCommands);
        if (commands.get(instructionToReplace).contains("jmp")) {
          commands.set(
              instructionToReplace, commands.get(instructionToReplace).replace("jmp", "nop"));
        } else if (commands.get(instructionToReplace).contains("nop")) {
          commands.set(
              instructionToReplace, commands.get(instructionToReplace).replace("nop", "jmp"));
        }

        boolean[] visited = new boolean[commands.size()];
        int i = 0;
        int acc = 0;

        while (!visited[i]) {
          visited[i] = true;
          String[] command = commands.get(i).split(" ");

          if ("acc".equals(command[0])) {
            acc += Integer.parseInt(command[1]);
          }
          if ("jmp".equals(command[0])) {
            i += Integer.parseInt(command[1]);
          } else {
            ++i;
          }

          if (i == commands.size()) {
            terminated = true;
            System.out.println(acc);
            break;
          }
        }

        ++instructionToReplace;
      }
    }
  }
}
