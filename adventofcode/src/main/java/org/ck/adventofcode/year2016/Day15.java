package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161501,
    name = "Day 15: Timing is Everything",
    url = "https://adventofcode.com/2016/day/15",
    category = "2016")
@Solution(
    id = 20161502,
    name = "Day 15: Timing is Everything - Part 2",
    url = "https://adventofcode.com/2016/day/15#part2",
    category = "2016")
public class Day15 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "Disc #(?<number>\\d+) has (?<positions>\\d+) positions; at time=0, it is at position (?<start>\\d+).");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    Set<Disc> discs = new HashSet<>();

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.matches()) {
        discs.add(
            new Disc(
                Integer.parseInt(matcher.group("number")),
                Integer.parseInt(matcher.group("positions")),
                Integer.parseInt(matcher.group("start"))));
      }
    }

    for (int i = 0; i < Integer.MAX_VALUE; ++i) {
      int test = i;

      if (discs.stream()
          .allMatch(disc -> (disc.start() + disc.number() + test) % disc.positions() == 0)) {
        print(i);
        return;
      }
    }
  }

  private record Disc(int number, int positions, int start) {}
}
