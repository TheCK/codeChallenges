package org.ck.adventofcode.year2021.day02;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20210202,
    name = "Day 2: Dive! - Part 2",
    url = "https://adventofcode.com/2021/day/2#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    int x = 0;
    int z = 0;

    int aim = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        int value = Integer.parseInt(line[1]);

        switch (line[0]) {
          case "forward":
            x += value;
            z += aim * value;
            break;
          case "down":
            aim += value;
            break;
          case "up":
            aim -= value;
            break;
        }
      }
    }

    System.out.println(x * z);
  }
}
