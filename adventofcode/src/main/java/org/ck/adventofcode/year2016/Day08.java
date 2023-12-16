package org.ck.adventofcode.year2016;

import java.util.Scanner;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160801,
    name = "Day 8: Two-Factor Authentication",
    url = "https://adventofcode.com/2016/day/8",
    category = "2016")
@Solution(
    id = 20160802,
    name = "Day 8: Two-Factor Authentication - Part 2",
    url = "https://adventofcode.com/2016/day/8#part2",
    category = "2016")
public class Day08 extends AOCSolution {

  public static final String COLUMN = "column";
  public static final String ROW = "row";

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        grid -> {
          int count = 0;

          for (int x = 0; x < grid[0].length; ++x) {
            for (int y = 0; y < grid.length; ++y) {
              if (grid[y][x] == '#') {
                ++count;
              }
            }
          }

          return count;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        grid -> {
          final StringBuilder builder = new StringBuilder();

          for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
              builder.append(grid[y][x]);
            }
            if (y != 5) {
              builder.append(System.lineSeparator());
            }
          }

          return builder.toString();
        });
  }

  private void run(final Scanner in, final Function<char[][], Object> getResult) {
    char[][] grid = initializeGrid();

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(" ");

      if ("rect".equals(line[0])) {
        drawRect(grid, line);
      } else {
        grid = rotate(grid, line);
      }
    }

    print(getResult.apply(grid));
  }

  private char[][] initializeGrid() {
    final char[][] grid = new char[6][50];

    for (int x = 0; x < 50; ++x) {
      for (int y = 0; y < 6; ++y) {
        grid[y][x] = ' ';
      }
    }

    return grid;
  }

  private void drawRect(final char[][] grid, final String[] line) {
    final String[] rect = line[1].split("x");

    for (int x = 0; x < Integer.parseInt(rect[0]); ++x) {
      for (int y = 0; y < Integer.parseInt(rect[1]); ++y) {
        grid[y][x] = '#';
      }
    }
  }

  private char[][] rotate(final char[][] grid, final String[] line) {
    final char[][] newGrid = copyGrid(grid);

    final int xMin = COLUMN.equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : 0;
    final int xMax =
        COLUMN.equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : grid[0].length - 1;

    final int yMin = ROW.equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : 0;
    final int yMax =
        ROW.equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : grid.length - 1;

    final int distance = Integer.parseInt(line[4]);

    for (int x = xMin; x <= xMax; ++x) {
      for (int y = yMin; y <= yMax; ++y) {
        newGrid[COLUMN.equals(line[1]) ? (y + distance) % grid.length : y][
                ROW.equals(line[1]) ? (x + distance) % grid[0].length : x] =
            grid[y][x];
      }
    }

    return newGrid;
  }

  private static char[][] copyGrid(final char[][] grid) {
    final char[][] newGrid = new char[grid.length][grid[0].length];

    for (int x = 0; x < grid[0].length; ++x) {
      for (int y = 0; y < grid.length; ++y) {
        newGrid[y][x] = grid[y][x];
      }
    }
    return newGrid;
  }
}
