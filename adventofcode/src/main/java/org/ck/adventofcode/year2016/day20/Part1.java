package org.ck.adventofcode.year2016.day20;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20162001,
    name = "Day 20: Firewall Rules",
    url = "https://adventofcode.com/2016/day/20",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    List<Range> blocked = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] input = in.nextLine().split("-");

        blocked.add(new Range(Long.parseLong(input[0]), Long.parseLong(input[1])));
      }
    }

    long ip = 0;

    while (true) {
      long currentIp = ip;

      final Optional<Range> max =
          blocked.stream()
              .filter(block -> block.start() <= currentIp && currentIp <= block.end())
              .max(Comparator.comparingLong(Range::end));

      if (max.isPresent()) {
        ip = max.get().end() + 1;
      } else {
        break;
      }
    }

    System.out.println(ip);
  }

  private record Range(long start, long end) {}
}
