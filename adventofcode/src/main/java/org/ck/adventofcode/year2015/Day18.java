package org.ck.adventofcode.year2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151801,
    name = "Day 18: Like a GIF For Your Yard",
    url = "https://adventofcode.com/2015/day/18",
    category = "2015")
@Solution(
    id = 20151802,
    name = "Day 18: Like a GIF For Your Yard - Part 2",
    url = "https://adventofcode.com/2015/day/18#part2",
    category = "2015")
public class Day18 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, grid -> {});
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day18::fixGrid);
  }

  private void run(final Scanner in, final Consumer<List<List<String>>> fixGrid) {
    final int cycles = in.nextInt();
    in.nextLine();

    List<List<String>> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(Arrays.asList(in.nextLine().split("")));
    }

    fixGrid.accept(grid);

    for (int i = 0; i < cycles; ++i) {
      final List<List<String>> copy = new ArrayList<>();

      for (int x = 0; x < grid.size(); ++x) {
        copy.add(new ArrayList<>());

        for (int y = 0; y < grid.get(x).size(); ++y) {
          int alive = 0;
          for (int dx = Math.max(x - 1, 0); dx <= Math.min(x + 1, grid.size() - 1); ++dx) {
            for (int dy = Math.max(y - 1, 0); dy <= Math.min(y + 1, grid.size() - 1); ++dy) {
              if (dx == x && dy == y) {
                continue;
              }

              if ("#".equals(grid.get(dx).get(dy))) {
                ++alive;
              }
            }
          }

          if ("#".equals(grid.get(x).get(y))) {
            if (alive >= 2 && alive <= 3) {
              copy.get(x).add("#");
            } else {
              copy.get(x).add(".");
            }
          } else {
            if (alive == 3) {
              copy.get(x).add("#");
            } else {
              copy.get(x).add(".");
            }
          }
        }
      }

      grid = copy;
      fixGrid.accept(grid);
    }

    int alive = 0;
    for (final List<String> strings : grid) {
      for (final String string : strings) {
        if ("#".equals(string)) {
          ++alive;
        }
      }
    }

    print(alive);
  }

  private static void fixGrid(final List<List<String>> grid) {
    grid.get(0).set(0, "#");
    grid.get(0).set(grid.get(0).size() - 1, "#");
    grid.get(grid.size() - 1).set(0, "#");
    grid.get(grid.size() - 1).set(grid.get(0).size() - 1, "#");
  }
}
