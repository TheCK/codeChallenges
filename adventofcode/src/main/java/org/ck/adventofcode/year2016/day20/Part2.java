package org.ck.adventofcode.year2016.day20;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20162002,
    name = "Day 20: Firewall Rules - Part 2",
    url = "https://adventofcode.com/2016/day/20",
    category = "2016")
public class Part2 {
  public static void main(String[] args) {
    List<Range> blocked = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] input = in.nextLine().split("-");

        blocked.add(new Range(Long.parseLong(input[0]), Long.parseLong(input[1])));
      }
    }

    long count = 0;
    long ip = 0;

    while (ip <= 4294967295L) {
      long currentIp = ip;

      final Optional<Range> max =
          blocked.stream()
              .filter(block -> block.start() <= currentIp && currentIp <= block.end())
              .max(Comparator.comparingLong(Range::end));

      if (max.isPresent()) {
        ip = max.get().end() + 1;
      } else {
        ++count;
        ++ip;
      }
    }

    System.out.println(count);
  }

  private record Range(long start, long end) {}
}
