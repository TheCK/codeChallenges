package org.ck.adventofcode.year2020.day09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Queue;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200902,
    name = "Day 9: Encoding Error - Part 2",
    url = "https://adventofcode.com/2020/day/9#part2",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int preamble = in.nextInt();
      ArrayDeque<Long> previous = new ArrayDeque<>();
      List<Long> numbers = new ArrayList<>();

      for (int i = 0; i < preamble; ++i) {
        previous.add(in.nextLong());
      }

      numbers.addAll(previous);
      long invalid = 0;

      while (in.hasNextLong()) {
        long current = in.nextLong();

        if (invalid == 0 && !addsUp(previous, current)) {
          invalid = current;
        }

        numbers.add(current);
        previous.add(current);
        previous.remove();
      }

      long[] sums = new long[numbers.size()];
      sums[0] = numbers.get(0);

      for (int i = 1; i < numbers.size(); ++i) {
        sums[i] = sums[i - 1] + numbers.get(i);
      }

      for (int i = 0; i < numbers.size(); ++i) {
        for (int j = i + 1; j < numbers.size(); ++j) {
          if (invalid == sums[j] - sums[i]) {
            LongSummaryStatistics stats =
                numbers.subList(i, j).stream().mapToLong(l -> l).summaryStatistics();

            System.out.println(stats.getMax() + stats.getMin());
            return;
          }
        }
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
