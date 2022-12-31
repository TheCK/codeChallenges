package org.ck.adventofcode.year2020.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201101,
    name = "Day 11: Seating System",
    url = "https://adventofcode.com/2020/day/11",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<String> lines = new ArrayList<>();
      while (in.hasNextLine()) {
        lines.add(in.nextLine());
      }

      char[][] grid = new char[lines.size()][lines.get(0).length()];
      for (int i = 0; i < lines.size(); ++i) {
        for (int j = 0; j < lines.get(0).length(); ++j) {
          grid[i][j] = lines.get(i).charAt(j);
        }
      }

      char[][] newGrid = null;
      while (true) {
        newGrid = copy(grid);

        for (int i = 0; i < grid.length; ++i) {
          for (int j = 0; j < grid[0].length; ++j) {
            if (grid[i][j] == '.') {
              continue;
            }

            int n = getNeigbours(grid, i, j);

            if (grid[i][j] == 'L' && n == 0) {
              newGrid[i][j] = '#';
            } else if (grid[i][j] == '#' && n >= 4) {
              newGrid[i][j] = 'L';
            }
          }
        }

        if (equals(grid, newGrid)) {
          break;
        }

        grid = newGrid;
      }

      System.out.println(countSeated(newGrid));
    }
  }

  private static int countSeated(char[][] grid) {
    int seated = 0;

    for (char[] chars : grid) {
      for (char aChar : chars) {
        if (aChar == '#') {
          ++seated;
        }
      }
    }

    return seated;
  }

  private static int getNeigbours(char[][] grid, int i, int j) {
    int neighbours = 0;

    for (int li = Math.max(i - 1, 0); li <= i + 1 && li < grid.length; ++li) {
      for (int lj = Math.max(j - 1, 0); lj <= j + 1 && lj < grid[0].length; ++lj) {
        if (i == li && j == lj) {
          continue;
        }

        if (grid[li][lj] == '#') {
          ++neighbours;
        }
      }
    }

    return neighbours;
  }

  private static boolean equals(char[][] grid, char[][] newGrid) {
    if (newGrid == null) {
      return false;
    }

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (grid[i][j] != newGrid[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  private static char[][] copy(char[][] grid) {
    char[][] newGrid = new char[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; ++i) {
      System.arraycopy(grid[i], 0, newGrid[i], 0, grid[0].length);
    }

    return newGrid;
  }
}
