package org.ck.adventofcode.year2021.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210902,
    name = "Day 9: Smoke Basin - Part 2",
    url = "https://adventofcode.com/2021/day/9#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    List<int[]> grid = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        grid.add(
            Arrays.stream(in.nextLine().split(""))
                .mapToInt(Integer::parseInt)
                .map(x -> x == 9 ? 9 : 0)
                .toArray());
      }
    }

    List<Integer> bassins = new ArrayList<>();
    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        if (grid.get(y)[x] == 0) {
          bassins.add(findSize(grid, y, x));
        }
      }
    }

    System.out.println(
        bassins.stream()
            .sorted((x1, x2) -> Integer.compare(x2, x1))
            .limit(3)
            .reduce(1, (x1, x2) -> x1 * x2));
  }

  private static int findSize(final List<int[]> grid, int y, int x) {
    int size = 1;
    grid.get(y)[x] = 1;

    if (y > 0 && grid.get(y - 1)[x] == 0) {
      size += findSize(grid, y - 1, x);
    }
    if (y < grid.size() - 1 && grid.get(y + 1)[x] == 0) {
      size += findSize(grid, y + 1, x);
    }

    if (x > 0 && grid.get(y)[x - 1] == 0) {
      size += findSize(grid, y, x - 1);
    }
    if (x < grid.get(y).length - 1 && grid.get(y)[x + 1] == 0) {
      size += findSize(grid, y, x + 1);
    }

    return size;
  }
}
