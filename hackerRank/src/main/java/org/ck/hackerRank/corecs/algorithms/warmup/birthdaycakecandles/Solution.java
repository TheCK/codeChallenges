package org.ck.hackerRank.corecs.algorithms.warmup.birthdaycakecandles;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 10110,
    name = "Birthday Cake Candles",
    url = "https://www.hackerrank.com/challenges/birthday-cake-candles",
    category = "Algorithms",
    subCategory = "Warmup")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int max = 0;
      int maxCount = 1;
      for (int i = 0; i < n; ++i) {
        int current = in.nextInt();

        if (current == max) {
          ++maxCount;
        } else if (current > max) {
          max = current;
          maxCount = 1;
        }
      }

      System.out.println(maxCount);
    }
  }
}
