package org.ck.hackerrank.contests.projecteuler.problem009;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 99990009,
    name = "Project Euler #9: Special Pythagorean triplet",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler009",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        int n = in.nextInt();

        int max = -1;
        for (int a = 1; a < n; ++a) {
          int x = n - a;
          int c = (a * a + x * x) / (2 * x);
          int b = n - a - c;

          if ((a < b) && (b < c) && (a + b + c == n) && (a * a + b * b == c * c)) {
            max = Math.max(max, a * b * c);
          }
        }

        System.out.println(max);
      }
    }
  }
}
