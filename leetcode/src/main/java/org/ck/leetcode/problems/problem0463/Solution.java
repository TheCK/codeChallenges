package org.ck.leetcode.problems.problem0463;

@org.ck.codechallengelib.annotation.Solution(
    id = 100463,
    name = "463. Island Perimeter",
    url = "https://leetcode.com/problems/island-perimeter",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Depth-First Search", "Breadth-First Search", "Matrix"})
public class Solution {
  public int islandPerimeter(int[][] grid) {
    int result = 0;

    for (int y = 0; y < grid.length; ++y) {
      for (int x = 0; x < grid[y].length; ++x) {
        if (grid[y][x] == 1) {
          if (y == 0) {
            ++result;
          } else {
            result += grid[y - 1][x] == 0 ? 1 : 0;
          }

          if (y == grid.length - 1) {
            ++result;
          } else {
            result += grid[y + 1][x] == 0 ? 1 : 0;
          }

          if (x == 0) {
            ++result;
          } else {
            result += grid[y][x - 1] == 0 ? 1 : 0;
          }

          if (x == grid[y].length - 1) {
            ++result;
          } else {
            result += grid[y][x + 1] == 0 ? 1 : 0;
          }
        }
      }
    }

    return result;
  }
}
