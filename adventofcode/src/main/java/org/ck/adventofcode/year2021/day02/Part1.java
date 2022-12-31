package org.ck.adventofcode.year2021.day02;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210201,
    name = "Day 2: Dive!",
    url = "https://adventofcode.com/2021/day/2",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    int x = 0;
    int z = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        int value = Integer.parseInt(line[1]);

        switch (line[0]) {
          case "forward" -> x += value;
          case "down" -> z += value;
          case "up" -> z -= value;
        }
      }
    }

    System.out.println(x * z);
  }
}
