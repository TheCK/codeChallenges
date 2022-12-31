package org.ck.hackerrank.languages.java.datastructures.subarray;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40204003,
    name = "Java Subarray",
    url = "https://www.hackerrank.com/challenges/java-negative-subarray",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int a[] = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = in.nextInt();
      }

      int count = 0;
      for (int i = 0; i < n; ++i) {
        for (int j = i; j < n; ++j) {
          if (sum(a, i, j) < 0) {
            ++count;
          }
        }
      }

      System.out.println(count);
    }
  }

  private static int sum(int[] a, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; ++i) {
      sum += a[i];
    }

    return sum;
  }
}
