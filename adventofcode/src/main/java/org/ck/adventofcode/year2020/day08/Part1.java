package org.ck.adventofcode.year2020.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20200801,
    name = "Day 8: Handheld Halting",
    url = "https://adventofcode.com/2020/day/8",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<String> commands = new ArrayList<>();
      while (in.hasNextLine()) {
        commands.add(in.nextLine());
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
      }

      System.out.println(acc);
    }
  }
}
