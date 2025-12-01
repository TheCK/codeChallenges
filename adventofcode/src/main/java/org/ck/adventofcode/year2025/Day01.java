package org.ck.adventofcode.year2025;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Gatherer;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250101,
    name = "Day 1: Secret Entrance",
    url = "https://adventofcode.com/2025/day/1",
    category = "2025")
@Solution(
    id = 20250102,
    name = "Day 1: Secret Entrance - Part 2",
    url = "https://adventofcode.com/2025/day/1#part2",
    category = "2025")
public class Day01 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        Gatherer.ofSequential(
            () -> new AtomicInteger(50),
            (state, rotation, downstream) -> {
              int current = state.get() + rotation;

              state.set(((100 * (1 + Math.abs(current) / 100)) + current) % 100);
              if (state.get() == 0) {
                downstream.push(1);
              }

              return !downstream.isRejecting();
            }));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        Gatherer.ofSequential(
            () -> new AtomicInteger(50),
            (state, rotation, downstream) -> {
              final int current = state.get() + rotation;

              final int zeroHits =
                  (Math.abs(current) / 100)
                      + (current == 0 || current < 0 && state.get() > 0 ? 1 : 0);
              downstream.push(zeroHits);

              state.set(((100 * (1 + Math.abs(current) / 100)) + current) % 100);
              return !downstream.isRejecting();
            }));
  }

  private void run(final Scanner in, Gatherer<Integer, AtomicInteger, Integer> gatherer) {
    final List<String> lines = new ArrayList<>();
    while (in.hasNextLine()) {
      lines.add(in.nextLine());
    }

    print(
        lines.stream()
            .map(line -> (line.charAt(0) == 'R' ? 1 : -1) * Integer.parseInt(line.substring(1)))
            .gather(gatherer)
            .mapToInt(Integer::intValue)
            .sum());
  }
}
