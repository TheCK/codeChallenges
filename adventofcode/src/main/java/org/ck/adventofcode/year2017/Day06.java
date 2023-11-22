package org.ck.adventofcode.year2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.ToIntBiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170601,
    name = "Day 6: Memory Reallocation",
    url = "https://adventofcode.com/2017/day/6",
    category = "2017")
@Solution(
    id = 20170602,
    name = "Day 6: Memory Reallocation - Part 2",
    url = "https://adventofcode.com/2017/day/6#part2",
    category = "2017")
public class Day06 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (history, memory) -> 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (history, memory) -> history.get(history.indexOf(new HistoryEntry(memory, 0))).cycle());
  }

  private void run(
      final Scanner in,
      final ToIntBiFunction<List<HistoryEntry>, List<Integer>> getOffsetFromCount) {
    List<Integer> memory = new ArrayList<>();

    while (in.hasNextInt()) {
      memory.add(in.nextInt());
    }

    final List<HistoryEntry> history = new ArrayList<>();

    int count = 0;

    while (!history.contains(new HistoryEntry(memory, count))) {
      history.add(new HistoryEntry(memory, count));

      final List<Integer> newMemory = new ArrayList<>(memory);
      int index = findMaxIndex(newMemory);

      int blocks = newMemory.get(index);
      newMemory.set(index, 0);

      while (blocks > 0) {
        index = (index + 1) % newMemory.size();
        newMemory.set(index, newMemory.get(index) + 1);

        --blocks;
      }

      memory = newMemory;
      ++count;
    }

    print(count - getOffsetFromCount.applyAsInt(history, memory));
  }

  private static int findMaxIndex(final List<Integer> memory) {
    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < memory.size(); ++i) {
      if (max < memory.get(i)) {
        max = memory.get(i);
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  private record HistoryEntry(List<Integer> memory, int cycle) {
    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }

      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final HistoryEntry that = (HistoryEntry) o;
      return Objects.equals(memory, that.memory);
    }

    @Override
    public int hashCode() {
      return Objects.hash(memory);
    }
  }
}
