package org.ck.adventofcode.year2015.day19;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20151902,
    name = "Day 19: Medicine for Rudolph - Part 2",
    url = "https://adventofcode.com/2015/day/19#part2",
    category = "2015")
public class Part2 {

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      Map<String, Set<String>> replacements = new HashMap<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isBlank()) {
          break;
        }

        final String[] split = line.split(" => ");
        replacements.computeIfAbsent(split[0], (key) -> new HashSet<>());
        replacements.get(split[0]).add(split[1]);
      }

      String wanted = in.nextLine();

      PriorityQueue<Result> queue = new PriorityQueue<>((r1, r2) -> Integer.compare(r2.steps(), r1.steps()));
      queue.add(new Result(wanted, 0));

      Map<String, Integer> cache = new HashMap<>();

      while (!queue.isEmpty()) {
        Result current = queue.poll();
        if ("e".equals(current.current())) {
          System.out.println(current.steps());
          break;
        }

        for (Map.Entry<String, Set<String>> entry : replacements.entrySet()) {
          String key = entry.getKey();

          for (String replace : entry.getValue()) {
            int index = 0;

            while (index >= 0) {
              int start = current.current().indexOf(replace, index);

              if (start >= 0) {
                index = start + replace.length();

                final Result newResult = new Result(
                        current.current().substring(0, start)
                                + key
                                + current.current().substring(index),
                        current.steps() + 1);

                if (!cache.containsKey(newResult.current()) || newResult.steps() < cache.get(newResult.current())) {
                  queue.add(newResult);
                  cache.put(newResult.current(), newResult.steps());
                }
              } else {
                index = start;
              }
            }
          }
        }
      }
    }
  }

  private record Result(String current, int steps) {
    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Result result = (Result) o;
      return Objects.equals(current, result.current);
    }

    @Override
    public int hashCode() {
      return Objects.hash(current);
    }
  }
}
