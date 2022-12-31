package org.ck.adventofcode.year2020.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201701,
    name = "Day 17: Conway Cubes",
    url = "https://adventofcode.com/2020/day/17",
    category = "2020")
public class Part1 {
  private static final int CYCLES = 6;

  public static void main(String[] args) {
    List<String> lines = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        lines.add(in.nextLine());
      }
    }

    int[][][] grid =
        new int[lines.get(0).length() + 2 * CYCLES][lines.size() + 2 * CYCLES][1 + 2 * CYCLES];

    for (int x = CYCLES; x < CYCLES + lines.get(0).length(); ++x) {
      for (int y = CYCLES; y < CYCLES + lines.size(); ++y) {
        if (lines.get(y - CYCLES).charAt(x - CYCLES) == '#') {
          grid[x][y][CYCLES] = 1;
        }
      }
    }

    for (int i = 0; i < CYCLES; ++i) {
      int[][][] newGrid = new int[grid.length][grid[0].length][grid[0][0].length];

      for (int newX = 0; newX < newGrid.length; ++newX) {
        for (int newY = 0; newY < newGrid[newX].length; ++newY) {
          for (int newZ = 0; newZ < newGrid[newX][newY].length; ++newZ) {
            int neighbours = 0;
            for (int oldX = Math.max(0, newX - 1);
                oldX < Math.min(newX + 2, newGrid.length);
                ++oldX) {
              for (int oldY = Math.max(0, newY - 1);
                  oldY < Math.min(newY + 2, newGrid[newX].length);
                  ++oldY) {
                for (int oldZ = Math.max(0, newZ - 1);
                    oldZ < Math.min(newZ + 2, newGrid[newX][newY].length);
                    ++oldZ) {
                  if (oldX == newX && oldY == newY && oldZ == newZ) {
                    continue;
                  }

                  neighbours += grid[oldX][oldY][oldZ];
                }
              }
            }

            if (neighbours == 3 || grid[newX][newY][newZ] == 1 && neighbours == 2) {
              newGrid[newX][newY][newZ] = 1;
            }
          }
        }
      }

      grid = newGrid;
    }

    System.out.println(
        Arrays.stream(grid).flatMap(Arrays::stream).flatMapToInt(Arrays::stream).sum());
  }
}
