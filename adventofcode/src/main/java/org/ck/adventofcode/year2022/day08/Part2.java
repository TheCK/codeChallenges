package org.ck.adventofcode.year2022.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20220802,
    name = "Day 8: Treetop Tree House - Part 2",
    url = "https://adventofcode.com/2022/day/8#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<List<Integer>> grid = new ArrayList<>();
      while (in.hasNextLine()) {
        grid.add(in.nextLine().chars().boxed().toList());
      }

      int maxViewPoints = 0;

      for (int y = 1; y < grid.size() - 1; ++y) {
        for (int x = 1; x < grid.get(y).size() - 1; ++x) {
          int value = grid.get(y).get(x);
          int countUp =
              count(
                  grid,
                  value,
                  x,
                  y - 1,
                  oldX -> oldX,
                  oldY -> oldY - 1,
                  currentX -> false,
                  currentY -> currentY >= 0);
          int countDown =
              count(
                  grid,
                  value,
                  x,
                  y + 1,
                  oldX -> oldX,
                  oldY -> oldY + 1,
                  currentX -> false,
                  currentY -> currentY < grid.size());
          int countLeft =
              count(
                  grid,
                  value,
                  x - 1,
                  y,
                  oldX -> oldX - 1,
                  oldY -> oldY,
                  currentX -> currentX >= 0,
                  currentY -> false);
          int countRight =
              count(
                  grid,
                  value,
                  x + 1,
                  y,
                  oldX -> oldX + 1,
                  oldY -> oldY,
                  currentX -> currentX < grid.get(0).size(),
                  currentY -> false);

          int viewPoints = countUp * countDown * countLeft * countRight;

          if (viewPoints > maxViewPoints) {
            maxViewPoints = viewPoints;
          }
        }
      }

      System.out.println(maxViewPoints);
    }
  }

  private static int count(
      final List<List<Integer>> grid,
      final int value,
      final int startX,
      final int startY,
      final IntFunction<Integer> columnMapper,
      final IntFunction<Integer> rowMapper,
      final IntPredicate columnChecker,
      final IntPredicate rowChecker) {
    int visibleTrees = 0;

    int y = startY;
    do {
      int x = startX;
      do {
        if (grid.get(y).get(x) < value) {
          ++visibleTrees;
        }

        if (grid.get(y).get(x) >= value) {
          return visibleTrees + 1;
        }

        x = columnMapper.apply(x);
      } while (columnChecker.test(x));

      y = rowMapper.apply(y);
    } while (rowChecker.test(y));

    return visibleTrees;
  }
}
