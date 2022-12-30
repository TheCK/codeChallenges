package org.ck.hackerrank.contests.projecteuler.problem008;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 99990008,
    name = "Project Euler #8: Largest product in a series",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler008",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String number = in.nextLine();

        long max = 0;

        for (int i = 0; i <= number.length() - k; ++i) {
          String subString = number.substring(i, i + k);

          if (!subString.contains("0")) {
            long current = 1;

            for (int j = 0; j < k; ++j) {
              current *= Long.parseLong(subString.substring(j, j + 1));
            }

            max = Math.max(max, current);
          }
        }

        System.out.println(max);
      }
    }
  }
}
