package org.ck.hackerRank.languages.java.introduction.loopsii;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40201007,
    name = "Java Loops II",
    url = "https://www.hackerrank.com/challenges/java-loops",
    category = "Java",
    subCategory = "Introduction")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int cases = in.nextInt();

      for (int i = 0; i < cases; ++i) {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        int[] results = new int[n];
        for (int j = 0; j < n; ++j) {
          results[j] = a;
          for (int k = 0; k <= j; ++k) {
            results[j] += (int) Math.pow(2, k) * b;
          }
        }

        System.out.println(
            Arrays.stream(results)
                .mapToObj(x -> String.valueOf(x))
                .collect(Collectors.joining(" ")));
      }
    }
  }
}
