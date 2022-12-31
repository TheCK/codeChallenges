package org.ck.hackerrank.corecs.datastructures.arrays.array2dds;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 20102,
    name = "2D Array - DS",
    url = "https://www.hackerrank.com/challenges/2d-array",
    category = "Data Structures",
    subCategory = "Arrays")
public class Solution {
  private static final int MAX = 6;
  private static final int HOURGLASS_OFFSET = 2;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int[][] matrix = new int[6][6];

      for (Integer i = 0; i < MAX; ++i) {
        for (Integer j = 0; j < MAX; ++j) {
          matrix[i][j] = in.nextInt();
        }
      }

      int maximumSum = Integer.MIN_VALUE;

      for (Integer i = 0; i < MAX - HOURGLASS_OFFSET; ++i) {
        for (Integer j = 0; j < MAX - HOURGLASS_OFFSET; ++j) {
          int currentSum = 0;

          currentSum += matrix[i][j];
          currentSum += matrix[i][j + 1];
          currentSum += matrix[i][j + 2];

          currentSum += matrix[i + 1][j + 1];

          currentSum += matrix[i + 2][j];
          currentSum += matrix[i + 2][j + 1];
          currentSum += matrix[i + 2][j + 2];

          maximumSum = Math.max(maximumSum, currentSum);
        }
      }

      System.out.println(maximumSum);
    }
  }
}
