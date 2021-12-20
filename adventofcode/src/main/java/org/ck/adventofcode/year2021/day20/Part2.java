package org.ck.adventofcode.year2021.day20;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20212002,
    name = "Day 20: Trench Map - Part 2",
    url = "https://adventofcode.com/2021/day/20#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String key = in.nextLine();
      in.nextLine();

      List<char[]> input = new ArrayList<>();

      while (in.hasNextLine()) {
        input.add(in.nextLine().toCharArray());
      }

      boolean[][] grid = new boolean[input.size()][input.get(0).length];

      for (int i = 0; i < input.size(); ++i) {
        for (int j = 0; j < input.get(i).length; ++j) {
          grid[j][i] = input.get(j)[i] == '#';
        }
      }

      boolean outside = false;
      for (int interation = 0; interation < 50; ++interation) {
        boolean[][] newGrid = new boolean[grid.length + 2][grid[0].length + 2];

        for (int i = 0; i < newGrid.length; ++i) {
          for (int j = 0; j < newGrid[0].length; ++j) {
            StringBuilder value = new StringBuilder();

            int y = i - 1;
            int x = j - 1;

            for (int dy = y - 1; dy <= y + 1; ++dy) {
              for (int dx = x - 1; dx <= x + 1; ++dx) {
                if (dy >= 0 && dy < grid.length && dx >= 0 && dx < grid[0].length) {
                  value.append(grid[dy][dx] ? "1" : "0");
                } else {
                  value.append(outside ? "1" : "0");
                }
              }
            }

            newGrid[i][j] = '#' == key.charAt(Integer.parseInt(value.toString(), 2));
          }
        }

        outside = (outside ? key.charAt(511) : key.charAt(0)) == '#';
        grid = newGrid;
      }

      int on = 0;
      for (int i = 0; i < grid.length; ++i) {
        for (int j = 0; j < grid[0].length; ++j) {
          if (grid[j][i]) {
            ++on;
          }
        }
      }

      System.out.println(on);
    }
  }
}
