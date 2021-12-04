package org.ck.adventofcode.year2021.day04;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

@Solution(
    id = 20210402,
    name = "Day 4: Giant Squid - Part 2",
    url = "https://adventofcode.com/2021/day/4#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> numbers =
          Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).collect(toList());

      List<int[][]> grids = new ArrayList<>();
      List<int[][]> selected = new ArrayList<>();
      List<Boolean> won = new ArrayList<>();

      int lines = 0;
      int[][] grid = new int[5][5];
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isBlank()) {
          lines = 0;
          grid = new int[5][5];
        } else {
          grid[lines] =
              Arrays.stream(line.split(" "))
                  .filter(value -> !"".equals(value))
                  .mapToInt(Integer::parseInt)
                  .toArray();

          ++lines;

          if (lines == 5) {
            grids.add(grid);
            selected.add(new int[5][5]);
            won.add(false);
          }
        }
      }

      for (int number : numbers) {
        for (int g = 0; g < grids.size(); ++g) {
          if (won.get(g)) {
            continue;
          }

          for (int x = 0; x < 5; ++x) {
            for (int y = 0; y < 5; ++y) {
              if (grids.get(g)[x][y] == number) {
                selected.get(g)[x][y] = 1;
              }
            }
          }

          final boolean verticalMatch =
              Arrays.stream(
                      Arrays.stream(selected.get(g))
                          .reduce(
                              new int[5],
                              (o, n) -> {
                                for (int i = 0; i < n.length; ++i) {
                                  o[i] += n[i];
                                }

                                return o;
                              }))
                  .anyMatch(x -> x == 5);

          final boolean horizontalMatch =
              Arrays.stream(selected.get(g))
                  .mapToInt(line -> Arrays.stream(line).sum())
                  .anyMatch(x -> x == 5);

          if (verticalMatch || horizontalMatch) {
            won.set(g, true);

            if (won.stream().reduce(true, (o, n) -> o && n)) {
              System.out.println(number * unusedSum(grids.get(g), selected.get(g)));
            }
          }
        }
      }
    }
  }

  private static int unusedSum(final int[][] grid, final int[][] selected) {
    int sum = 0;

    for (int x = 0; x < 5; ++x) {
      for (int y = 0; y < 5; ++y) {
        if (selected[x][y] == 0) {
          sum += grid[x][y];
        }
      }
    }

    return sum;
  }
}
