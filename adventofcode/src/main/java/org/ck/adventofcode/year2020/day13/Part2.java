package org.ck.adventofcode.year2020.day13;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201302,
    name = "Day 13: Shuttle Search - Part 2",
    url = "https://adventofcode.com/2020/day/13#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      in.nextLine();
      String[] line = in.nextLine().split(",");

      long s = Integer.parseInt(line[0]);
      long p = 0;
      for (int pn = 1; pn < line.length; ++pn) {
        if (line[pn].equals("x")) {
          continue;
        }

        long sn = Integer.parseInt(line[pn]);
        for (long i = 0; i < Long.MAX_VALUE; ++i) {
          long tmp = p + i * s;
          if (tmp % sn == (sn - (pn % sn))) {
            s *= sn;
            p = tmp;
            break;
          }
        }
      }

      System.out.println(p);
    }
  }
}
