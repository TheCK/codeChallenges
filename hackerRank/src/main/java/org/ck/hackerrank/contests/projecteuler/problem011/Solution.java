package org.ck.hackerrank.contests.projecteuler.problem011;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 99990011,
    name = "Project Euler #11: Largest product in a grid",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler011",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {
  private static final int[][] array = new int[20][20];

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      for (int i = 0; i < 20; ++i) {
        for (int j = 0; j < 20; ++j) {
          array[i][j] = in.nextInt();
        }
      }

      int max = 0;

      for (int i = 0; i < 20; ++i) {
        for (int j = 0; j < 20; ++j) {
          if (j <= 16) {
            max = Math.max(max, array[i][j] * array[i][j + 1] * array[i][j + 2] * array[i][j + 3]);
          }
          if (i <= 16) {
            max = Math.max(max, array[i][j] * array[i + 1][j] * array[i + 2][j] * array[i + 3][j]);
          }
          if (j <= 16 && i <= 16) {
            max =
                Math.max(
                    max,
                    array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2] * array[i + 3][j + 3]);
          }
          if (j >= 3 && i <= 16) {
            max =
                Math.max(
                    max,
                    array[i][j] * array[i + 1][j - 1] * array[i + 2][j - 2] * array[i + 3][j - 3]);
          }
        }
      }

      System.out.println(max);
    }
  }
}
