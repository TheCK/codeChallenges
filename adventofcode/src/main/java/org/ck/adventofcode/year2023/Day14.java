package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231401,
    name = "Day 14: Parabolic Reflector Dish",
    url = "https://adventofcode.com/2023/day/14",
    category = "2023")
@Solution(
    id = 20231402,
    name = "Day 14: Parabolic Reflector Dish - Part 2",
    url = "https://adventofcode.com/2023/day/14#part2",
    category = "2023")
public class Day14 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        1,
        (dish, cycle) -> {
          tiltNorth(dish);
          return 0;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    final Map<String, Integer> cache = new HashMap<>();

    run(
        in,
        1_000_000_000,
        (dish, cycle) -> {
          tiltNorth(dish);
          tiltWest(dish);
          tiltSouth(dish);
          tiltEast(dish);

          String key = dish.stream().map(String::new).collect(Collectors.joining());
          if (cache.containsKey(key)) {
            return cycle - cache.get(key);
          }

          cache.put(key, cycle);
          return 0;
        });
  }

  private void run(
      final Scanner in,
      final int cycles,
      final BiFunction<List<char[]>, Integer, Integer> dishCycle) {
    final List<char[]> dish = new ArrayList<>();

    while (in.hasNextLine()) {
      dish.add(in.nextLine().toCharArray());
    }

    int cycle = 0;
    while (cycle < cycles) {
      final int cycleLength = dishCycle.apply(dish, cycle);

      if (cycleLength != 0) {
        cycle += ((cycles - cycle) / cycleLength) * cycleLength;
      }

      ++cycle;
    }

    print(calcLoad(dish));
  }

  private long calcLoad(final List<char[]> dish) {
    long load = 0;

    for (int rowIndex = 0; rowIndex < dish.size(); ++rowIndex) {
      final char[] row = dish.get(rowIndex);

      for (final char mirror : row) {
        if (mirror == 'O') {
          load += (dish.size() - rowIndex);
        }
      }
    }

    return load;
  }

  private void tiltNorth(final List<char[]> dish) {
    for (int rowIndex = 0; rowIndex < dish.size(); ++rowIndex) {
      final char[] row = dish.get(rowIndex);

      for (int columnIndex = 0; columnIndex < row.length; ++columnIndex) {
        if (row[columnIndex] == 'O') {
          int rowAbove = rowIndex;

          while (rowAbove > 0 && dish.get(rowAbove - 1)[columnIndex] == '.') {
            --rowAbove;
          }

          if (rowIndex != rowAbove) {
            dish.get(rowAbove)[columnIndex] = 'O';
            row[columnIndex] = '.';
          }
        }
      }
    }
  }

  private void tiltSouth(final List<char[]> dish) {
    for (int rowIndex = dish.size() - 1; rowIndex >= 0; --rowIndex) {
      final char[] row = dish.get(rowIndex);

      for (int columnIndex = 0; columnIndex < row.length; ++columnIndex) {
        if (row[columnIndex] == 'O') {
          int rowBelow = rowIndex;

          while (rowBelow < dish.size() - 1 && dish.get(rowBelow + 1)[columnIndex] == '.') {
            ++rowBelow;
          }

          if (rowIndex != rowBelow) {
            dish.get(rowBelow)[columnIndex] = 'O';
            row[columnIndex] = '.';
          }
        }
      }
    }
  }

  private void tiltWest(final List<char[]> dish) {
    for (int columnIndex = 0; columnIndex < dish.getFirst().length; ++columnIndex) {
      for (int rowIndex = 0; rowIndex < dish.size(); ++rowIndex) {
        if (dish.get(rowIndex)[columnIndex] == 'O') {
          int columnToLeft = columnIndex;

          while (columnToLeft > 0 && dish.get(rowIndex)[columnToLeft - 1] == '.') {
            --columnToLeft;
          }

          if (columnIndex != columnToLeft) {
            dish.get(rowIndex)[columnToLeft] = 'O';
            dish.get(rowIndex)[columnIndex] = '.';
          }
        }
      }
    }
  }

  private void tiltEast(final List<char[]> dish) {
    for (int columnIndex = dish.getFirst().length - 1; columnIndex >= 0; --columnIndex) {
      for (int rowIndex = 0; rowIndex < dish.size(); ++rowIndex) {
        if (dish.get(rowIndex)[columnIndex] == 'O') {
          int columnToRight = columnIndex;

          while (columnToRight < dish.getFirst().length - 1
              && dish.get(rowIndex)[columnToRight + 1] == '.') {
            ++columnToRight;
          }

          if (columnIndex != columnToRight) {
            dish.get(rowIndex)[columnToRight] = 'O';
            dish.get(rowIndex)[columnIndex] = '.';
          }
        }
      }
    }
  }
}
