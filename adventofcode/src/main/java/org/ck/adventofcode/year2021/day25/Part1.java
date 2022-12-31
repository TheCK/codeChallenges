package org.ck.adventofcode.year2021.day25;

import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20212501,
    name = "Day 25: Sea Cucumber",
    url = "https://adventofcode.com/2021/day/25",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    List<char[]> input = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        input.add(in.nextLine().toCharArray());
      }
    }

    char[][] grid = new char[input.size()][input.get(0).length];

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (input.get(i)[j] == '>' || input.get(i)[j] == 'v') grid[i][j] = input.get(i)[j];
      }
    }

    boolean move = false;
    int moves = 0;
    do {
      move = false;
      ++moves;

      char[][] newGrid = new char[grid.length][grid[0].length];

      for (int i = 0; i < grid.length; ++i) {
        for (int j = 0; j < grid[i].length; ++j) {
          if (grid[i][j] == '>') {
            if (grid[i][(j + 1) % grid[i].length] == '\0') {
              newGrid[i][(j + 1) % newGrid[i].length] = '>';
              move = true;
            } else {
              newGrid[i][j] = '>';
            }
          }
        }
      }

      for (int i = 0; i < grid.length; ++i) {
        for (int j = 0; j < grid[i].length; ++j) {
          if (grid[i][j] == 'v') {
            if (newGrid[(i + 1) % newGrid.length][j] != '>'
                && grid[(i + 1) % grid.length][j] != 'v') {
              newGrid[(i + 1) % newGrid.length][j] = 'v';
              move = true;
            } else {
              newGrid[i][j] = 'v';
            }
          }
        }
      }

      grid = newGrid;
    } while (move);

    System.out.println(moves);
  }
}
