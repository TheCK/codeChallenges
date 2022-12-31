package org.ck.hackerrank.languages.java.datastructures.java2darray;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40204002,
    name = "Java 2D Array",
    url = "https://www.hackerrank.com/challenges/java-2d-array",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int[][] arr = new int[6][6];

      for (int i = 0; i < 6; ++i) {
        for (int j = 0; j < 6; ++j) {
          arr[i][j] = in.nextInt();
        }
      }

      int max = Integer.MIN_VALUE;
      for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
          int sum =
              arr[i][j]
                  + arr[i][j + 1]
                  + arr[i][j + 2]
                  + arr[i + 1][j + 1]
                  + arr[i + 2][j]
                  + arr[i + 2][j + 1]
                  + arr[i + 2][j + 2];

          max = Math.max(sum, max);
        }
      }

      System.out.println(max);
    }
  }
}
