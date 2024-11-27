package org.ck.adventofcode.year2016;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162001,
    name = "Day 20: Firewall Rules",
    url = "https://adventofcode.com/2016/day/20",
    category = "2016")
@Solution(
    id = 20162002,
    name = "Day 20: Firewall Rules - Part 2",
    url = "https://adventofcode.com/2016/day/20",
    category = "2016")
public class Day20 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, true);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, false);
  }

  private void run(final Scanner in, final boolean findFirstOnly) {
    final List<Range> blocked = new ArrayList<>();

    while (in.hasNextLine()) {
      final String[] input = in.nextLine().split("-");

      blocked.add(new Range(Long.parseLong(input[0]), Long.parseLong(input[1])));
    }

    long count = 0;
    long ip = 0;

    while (ip <= 4294967295L) {
      final long currentIp = ip;

      final Optional<Range> max =
          blocked.stream()
              .filter(block -> block.start() <= currentIp && currentIp <= block.end())
              .max(Comparator.comparingLong(Range::end));

      if (max.isPresent()) {
        ip = max.get().end() + 1;
      } else {
        if (findFirstOnly) {
          break;
        }

        ++count;
        ++ip;
      }
    }

    print(findFirstOnly ? ip : count);
  }

  private record Range(long start, long end) {}
}
