package org.ck.adventofcode.year2021.day11;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20211102,
    name = "Day 11: Dumbo Octopus - Part 2",
    url = "https://adventofcode.com/2021/day/11#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    List<int[]> grid = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        grid.add(Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray());
      }
    }

    int i = 0;
    while (true) {
      ++i;
      int flashes = 0;
      boolean[][] flashed = new boolean[grid.size()][grid.get(0).length];

      for (int y = 0; y < grid.size(); ++y) {
        for (int x = 0; x < grid.get(y).length; ++x) {
          ++grid.get(y)[x];
          if (grid.get(y)[x] == 10) {
            flashes += flash(grid, flashed, x, y);
          }
        }
      }

      for (int y = 0; y < grid.size(); ++y) {
        for (int x = 0; x < grid.get(y).length; ++x) {
          if (flashed[y][x]) {
            grid.get(y)[x] = 0;
          }
        }
      }

      if (flashes == grid.size() * grid.get(0).length) {
        break;
      }
    }

    System.out.println(i);
  }

  private static int flash(
      final List<int[]> grid, final boolean[][] flashed, final int x, final int y) {
    int flashes = 1;
    flashed[y][x] = true;

    for (int i = Math.max(0, y - 1); i <= Math.min(grid.size() - 1, y + 1); ++i) {
      for (int j = Math.max(0, x - 1); j <= Math.min(grid.get(i).length - 1, x + 1); ++j) {
        if (i == y && j == x) {
          continue;
        }

        if (!flashed[i][j]) {
          ++grid.get(i)[j];
          if (grid.get(i)[j] == 10) {
            flashes += flash(grid, flashed, j, i);
          }
        }
      }
    }

    return flashes;
  }
}
