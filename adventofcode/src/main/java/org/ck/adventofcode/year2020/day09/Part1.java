package org.ck.adventofcode.year2020.day09;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20200901,
    name = "Day 9: Encoding Error",
    url = "https://adventofcode.com/2020/day/9",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int preamble = in.nextInt();
      ArrayDeque<Long> previous = new ArrayDeque<>();

      for (int i = 0; i < preamble; ++i) {
        previous.add(in.nextLong());
      }

      while (in.hasNextLong()) {
        long current = in.nextLong();

        if (!addsUp(previous, current)) {
          System.out.println(current);
          break;
        }

        previous.add(current);
        previous.remove();
      }
    }
  }

  private static boolean addsUp(Queue<Long> previous, long current) {
    Long[] prevArray = previous.toArray(new Long[] {});

    for (int i = 0; i < previous.size(); ++i) {
      for (int j = i + 1; j < previous.size(); ++j) {
        if (prevArray[i] + prevArray[j] == current) {
          return true;
        }
      }
    }

    return false;
  }
}
