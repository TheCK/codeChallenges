package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151901,
    name = "Day 19: Medicine for Rudolph",
    url = "https://adventofcode.com/2015/day/19",
    category = "2015")
@Solution(
    id = 20151902,
    name = "Day 19: Medicine for Rudolph - Part 2",
    url = "https://adventofcode.com/2015/day/19#part2",
    category = "2015")
public class Day19 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false, (key, value) -> key, (key, value) -> value, Collection::size);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true, (key, value) -> value, (key, value) -> key, queue -> queue.peek().steps());
  }

  private void run(
      final Scanner in,
      final boolean shouldLoop,
      final BinaryOperator<String> getFrom,
      final BinaryOperator<String> getTo,
      final ToIntFunction<Queue<Result>> getResult) {
    final Map<String, Set<String>> replacements = new HashMap<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      if (line.isBlank()) {
        break;
      }

      final String[] split = line.split(" => ");
      replacements.computeIfAbsent(split[0], key -> new HashSet<>());
      replacements.get(split[0]).add(split[1]);
    }

    final String wanted = in.nextLine();

    final PriorityQueue<Result> queue =
        new PriorityQueue<>((r1, r2) -> Integer.compare(r2.steps(), r1.steps()));
    queue.add(new Result(wanted, 0));

    final Map<String, Integer> cache = new HashMap<>();

    do {
      if ("e".equals(queue.peek().current())) {
        break;
      }

      final Result current = queue.poll();

      for (Map.Entry<String, Set<String>> entry : replacements.entrySet()) {
        final String key = entry.getKey();

        for (final String value : entry.getValue()) {
          int index = 0;

          final String from = getFrom.apply(key, value);
          final String to = getTo.apply(key, value);

          while (index >= 0) {
            final int start = current.current().indexOf(from, index);

            if (start >= 0) {
              index = start + from.length();

              final Result newResult =
                  new Result(
                      current.current().substring(0, start)
                          + to
                          + current.current().substring(index),
                      current.steps() + 1);

              if (!cache.containsKey(newResult.current())
                  || newResult.steps() < cache.get(newResult.current())) {
                queue.add(newResult);
                cache.put(newResult.current(), newResult.steps());
              }
            } else {
              index = start;
            }
          }
        }
      }
    } while (shouldLoop);

    print(getResult.applyAsInt(queue));
  }

  private record Result(String current, int steps) {
    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final Result result = (Result) o;
      return Objects.equals(current, result.current);
    }

    @Override
    public int hashCode() {
      return Objects.hash(current);
    }
  }
}
