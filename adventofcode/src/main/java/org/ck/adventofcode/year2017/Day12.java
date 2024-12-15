package org.ck.adventofcode.year2017;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20171201,
    name = "Day 12: Digital Plumber",
    url = "https://adventofcode.com/2017/day/12",
    category = "2017")
@Solution(
    id = 20171202,
    name = "Day 12: Digital Plumber - Part 2",
    url = "https://adventofcode.com/2017/day/12#part2",
    category = "2017")
public class Day12 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day12::getReachableFromZero);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day12::getGroupCount);
  }

  private void run(final Scanner in, final ToIntFunction<Map<Integer, Set<Integer>>> getResult) {
    final Map<Integer, Set<Integer>> programs = new HashMap<>();

    while (in.hasNextLine()) {
      final String[] parts = in.nextLine().split(" <-> ");

      programs.put(
          Integer.parseInt(parts[0]),
          Arrays.stream(parts[1].split(", ")).map(Integer::parseInt).collect(Collectors.toSet()));
    }

    print(getResult.applyAsInt(programs));
  }

  private static int getReachableFromZero(final Map<Integer, Set<Integer>> programs) {
    final Set<Integer> reachable = new HashSet<>();
    final Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    while (!queue.isEmpty()) {
      final int current = queue.poll();
      if (reachable.contains(current)) {
        continue;
      }

      reachable.add(current);
      queue.addAll(programs.get(current));
    }

    return reachable.size();
  }

  private static int getGroupCount(Map<Integer, Set<Integer>> programs) {
    final Set<Integer> reached = new HashSet<>();

    int groups = 0;
    for (final int program : programs.keySet()) {
      if (!reached.contains(program)) {
        ++groups;

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(program);

        while (!queue.isEmpty()) {
          final int current = queue.poll();
          if (reached.contains(current)) {
            continue;
          }

          reached.add(current);
          queue.addAll(programs.get(current));
        }
      }
    }

    return groups;
  }
}
