package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.*;
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

  private void tilt(
      final List<char[]> dish,
      final LoopDefinition outerDef,
      final LoopDefinition innerDef,
      final Mapper rowMapper,
      final Mapper columnMapper,
      final BiPredicate<Integer, Integer> condition) {
    for (int outer = outerDef.start();
        outerDef.continueLoop().test(outer);
        outer = outerDef.step().applyAsInt(outer)) {
      for (int inner = innerDef.start();
          innerDef.continueLoop().test(inner);
          inner = innerDef.step().applyAsInt(inner)) {
        final int row = rowMapper.get().applyAsInt(outer, inner);
        final int column = columnMapper.get().applyAsInt(outer, inner);

        if (dish.get(row)[column] == 'O') {
          int otherRow = row;
          int otherColumn = column;

          while (condition.test(otherRow, otherColumn)
              && dish.get(rowMapper.getPeek().applyAsInt(otherRow))[
                      columnMapper.getPeek().applyAsInt(otherColumn)]
                  == '.') {
            otherRow = rowMapper.getPeek().applyAsInt(otherRow);
            otherColumn = columnMapper.getPeek().applyAsInt(otherColumn);
          }

          if (row != otherRow || column != otherColumn) {
            dish.get(otherRow)[otherColumn] = 'O';
            dish.get(row)[column] = '.';
          }
        }
      }
    }
  }

  private void tiltNorth(final List<char[]> dish) {
    tilt(
        dish,
        new LoopDefinition(0, outer -> outer < dish.size(), step -> step + 1),
        new LoopDefinition(0, inner -> inner < dish.getFirst().length, step -> step + 1),
        new Mapper((outer, inner) -> outer, row -> row - 1),
        new Mapper((outer, inner) -> inner, column -> column),
        (row, column) -> row > 0);
  }

  private void tiltSouth(final List<char[]> dish) {
    tilt(
        dish,
        new LoopDefinition(dish.size() - 1, outer -> outer >= 0, step -> step - 1),
        new LoopDefinition(0, inner -> inner < dish.getFirst().length, step -> step + 1),
        new Mapper((outer, inner) -> outer, row -> row + 1),
        new Mapper((outer, inner) -> inner, column -> column),
        (row, column) -> row < dish.size() - 1);
  }

  private void tiltWest(final List<char[]> dish) {
    tilt(
        dish,
        new LoopDefinition(0, outer -> outer < dish.getFirst().length, step -> step + 1),
        new LoopDefinition(0, inner -> inner < dish.size(), step -> step + 1),
        new Mapper((outer, inner) -> inner, row -> row),
        new Mapper((outer, inner) -> outer, column -> column - 1),
        (row, column) -> column > 0);
  }

  private void tiltEast(final List<char[]> dish) {
    tilt(
        dish,
        new LoopDefinition(dish.getFirst().length - 1, outer -> outer >= 0, step -> step - 1),
        new LoopDefinition(0, inner -> inner < dish.size(), step -> step + 1),
        new Mapper((outer, inner) -> inner, row -> row),
        new Mapper((outer, inner) -> outer, column -> column + 1),
        (row, column) -> column < dish.getFirst().length - 1);
  }

  private record LoopDefinition(int start, IntPredicate continueLoop, IntUnaryOperator step) {}

  private record Mapper(IntBinaryOperator get, IntUnaryOperator getPeek) {}
}
