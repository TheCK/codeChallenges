package org.ck.adventofcode.year2015.day18;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Solution(
    id = 20151802,
    name = "Day 18: Like a GIF For Your Yard - Part 2",
    url = "https://adventofcode.com/2015/day/18#part2",
    category = "2015")
public class Part2 {

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      int cycles = in.nextInt();
      in.nextLine();

      List<List<String>> grid = new ArrayList<>();

      while (in.hasNextLine()) {
        grid.add(Arrays.asList(in.nextLine().split("")));
      }

      fixGrid(grid);

      for (int i = 0; i < cycles; ++i) {
        List<List<String>> copy = new ArrayList<>();

        for (int x = 0; x < grid.size(); ++x) {
          copy.add(new ArrayList<>());

          for (int y = 0; y < grid.get(x).size(); ++y) {
            int alive = 0;
            for (int dx = Math.max(x - 1, 0); dx <= Math.min(x + 1, grid.size() - 1); ++dx) {
              for (int dy = Math.max(y - 1, 0); dy <= Math.min(y + 1, grid.size() - 1); ++dy) {
                if (dx == x && dy == y) {
                  continue;
                }

                if (grid.get(dx).get(dy).equals("#")) {
                  ++alive;
                }
              }
            }

            if (grid.get(x).get(y).equals("#")) {
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
        fixGrid(grid);
      }

      int alive = 0;
      for (List<String> strings : grid) {
        for (String string : strings) {
          if (string.equals("#")) {
            ++alive;
          }
        }
      }

      System.out.println(alive);
    }
  }

  private static void fixGrid(List<List<String>> grid) {
    grid.get(0).set(0, "#");
    grid.get(0).set(grid.get(0).size() - 1, "#");
    grid.get(grid.size() - 1).set(0, "#");
    grid.get(grid.size() - 1).set(grid.get(0).size() - 1, "#");
  }
}
