package org.ck.hackerrank.corecs.algorithms.implementation.beautifuldaysatthemovies;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10218,
    name = "Beautiful Days at the Movies",
    url = "https://www.hackerrank.com/challenges/beautiful-days-at-the-movies",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int i = in.nextInt();
      int j = in.nextInt();
      int k = in.nextInt();

      int beautifulDays = 0;
      for (i = i; i <= j; ++i) {
        if (Math.abs(i - reverse(i)) % k == 0) {
          ++beautifulDays;
        }
      }

      System.out.println(beautifulDays);
    }
  }

  private static int reverse(int i) {
    return Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
  }
}
