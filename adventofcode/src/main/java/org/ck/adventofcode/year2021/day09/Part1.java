package org.ck.adventofcode.year2021.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210901,
    name = "Day 9: Smoke Basin",
    url = "https://adventofcode.com/2021/day/9",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    List<int[]> grid = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        grid.add(Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray());
      }
    }

    int risk = 0;
    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        if ((y == 0 || grid.get(y - 1)[x] > grid.get(y)[x])
            && (x == 0 || grid.get(y)[x - 1] > grid.get(y)[x])
            && (y == grid.size() - 1 || grid.get(y + 1)[x] > grid.get(y)[x])
            && (x == grid.get(y).length - 1 || grid.get(y)[x + 1] > grid.get(y)[x])) {
          risk += 1 + grid.get(y)[x];
        }
      }
    }

    System.out.println(risk);
  }
}
