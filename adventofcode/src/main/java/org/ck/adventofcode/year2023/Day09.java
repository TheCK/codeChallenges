package org.ck.adventofcode.year2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230901,
    name = "Day 9: Mirage Maintenance",
    url = "https://adventofcode.com/2023/day/9",
    category = "2023")
@Solution(
    id = 20230902,
    name = "Day 9: Mirage Maintenance - Part 2",
    url = "https://adventofcode.com/2023/day/9#part2",
    category = "2023")
public class Day09 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (row, value) -> value + row.getLast());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (row, value) -> row.getFirst() - value);
  }

  private void run(final Scanner in, final BiFunction<List<Long>, Long, Long> getRowValue) {
    long sum = 0;

    while (in.hasNextLine()) {
      final List<List<Long>> numbers = new ArrayList<>();
      numbers.add(Arrays.stream(in.nextLine().split(" ")).map(Long::valueOf).toList());

      int rowIndex = 0;
      boolean allZero = false;

      while (!allZero) {
        final List<Long> row = numbers.get(rowIndex);
        final List<Long> newRow = new ArrayList<>();

        allZero = true;

        for (int i = 0; i < row.size() - 1; ++i) {
          final long difference = row.get(i + 1) - row.get(i);
          newRow.add(difference);

          if (difference != 0) {
            allZero = false;
          }
        }

        numbers.add(newRow);
        ++rowIndex;
      }

      long value = 0;
      while (rowIndex >= 0) {
        value = getRowValue.apply(numbers.get(rowIndex), value);
        --rowIndex;
      }

      sum += value;
    }

    print(sum);
  }
}
