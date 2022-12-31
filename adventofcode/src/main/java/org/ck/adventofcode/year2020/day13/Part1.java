package org.ck.adventofcode.year2020.day13;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20201301,
    name = "Day 13: Shuttle Search",
    url = "https://adventofcode.com/2020/day/13",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("\\D+");
      int earliestTime = in.nextInt();

      int shortestWait = Integer.MAX_VALUE;
      int bus = 0;
      while (in.hasNextInt()) {
        int schedule = in.nextInt();

        int timeSinceLastBus = earliestTime % schedule;
        int wait = 0;
        if (timeSinceLastBus != 0) {
          wait = schedule - timeSinceLastBus;
        }

        if (wait < shortestWait) {
          shortestWait = wait;
          bus = schedule;
        }
      }

      System.out.println(bus * shortestWait);
    }
  }
}
