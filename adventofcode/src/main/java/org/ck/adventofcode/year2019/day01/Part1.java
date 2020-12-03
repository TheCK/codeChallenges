package org.ck.adventofcode.year2019.day01;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20190101,
    name = "Day 1: The Tyranny of the Rocket Equation",
    url = "https://adventofcode.com/2019/day/1",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    int fuel = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        int moduleWeight = in.nextInt();

        fuel += (moduleWeight / 3) - 2;
      }
    }

    System.out.println(fuel);
  }
}
