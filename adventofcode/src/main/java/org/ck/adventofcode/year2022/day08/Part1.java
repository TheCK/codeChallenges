package org.ck.adventofcode.year2022.day08;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20220801,
    name = "Day 8: Treetop Tree House",
    url = "https://adventofcode.com/2022/day/8",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<List<Integer>> grid = new ArrayList<>();
      while (in.hasNextLine()) {
        grid.add(in.nextLine().chars().boxed().toList());
      }

      Set<Tree> visible = new HashSet<>();

      int[] maxRow = new int[grid.get(0).size()];
      int[] maxColumn = new int[grid.size()];

      for (int y = 0; y < grid.size(); ++y) {
        for (int x = 0; x < grid.get(y).size(); ++x) {
          int value = grid.get(y).get(x);
          if (maxRow[x] < value) {
            visible.add(new Tree(x, y));
            maxRow[x] = value;
          }

          if (maxColumn[y] < value) {
            visible.add(new Tree(x, y));
            maxColumn[y] = value;
          }
        }
      }

      maxRow = new int[grid.get(0).size()];
      maxColumn = new int[grid.size()];

      for (int y = grid.size() - 1; y >= 0; --y) {
        for (int x = grid.get(y).size() - 1; x >= 0; --x) {
          int value = grid.get(y).get(x);
          if (maxRow[x] < value) {
            visible.add(new Tree(x, y));
            maxRow[x] = value;
          }

          if (maxColumn[y] < value) {
            visible.add(new Tree(x, y));
            maxColumn[y] = value;
          }
        }
      }

      System.out.println(visible.size());
    }
  }

  record Tree(int x, int y) {}
}
