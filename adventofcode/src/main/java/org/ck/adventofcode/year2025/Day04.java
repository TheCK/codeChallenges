package org.ck.adventofcode.year2025;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250401,
    name = "Day 4: Printing Department",
    url = "https://adventofcode.com/2025/day/4",
    category = "2025")
@Solution(
    id = 20250402,
    name = "Day 4: Printing Department - Part 2",
    url = "https://adventofcode.com/2025/day/4#part2",
    category = "2025")
public class Day04 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean loop) {
    final List<String> rows = new ArrayList<>();

    while (in.hasNextLine()) {
      rows.add(in.nextLine());
    }

    char[][] grid = new char[rows.size()][rows.get(0).length()];
    for (int i = 0; i < rows.size(); ++i) {
      for (int j = 0; j < rows.get(i).length(); ++j) {
        grid[i][j] = rows.get(i).charAt(j);
      }
    }

    int movable = 0;
    boolean moved = false;
    do {
      char[][] newGrid = new char[grid.length][grid[0].length];
      moved = false;

      for (int row = 0; row < grid.length; ++row) {
        for (int column = 0; column < grid[row].length; ++column) {
          int surrounding = 0;

          for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, grid.length - 1); ++i) {
            for (int j = Math.max(column - 1, 0);
                j <= Math.min(column + 1, grid[i].length - 1);
                ++j) {
              if (i != row || j != column) {
                surrounding += grid[i][j] == '@' ? 1 : 0;
              }
            }
          }

          if (grid[row][column] == '@' && surrounding < 4) {
            moved = true;
            ++movable;
            newGrid[row][column] = '.';
          } else {
            newGrid[row][column] = grid[row][column];
          }
        }
      }

      grid = newGrid;
    } while (loop && moved);

    print(movable);
  }
}
