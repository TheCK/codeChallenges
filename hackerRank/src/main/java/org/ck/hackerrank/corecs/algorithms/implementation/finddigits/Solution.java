package org.ck.hackerrank.corecs.algorithms.implementation.finddigits;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10224,
    name = "Find Digits",
    url = "https://www.hackerrank.com/challenges/find-digits",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int cases = in.nextInt();

      for (int i = 0; i < cases; ++i) {
        long number = in.nextLong();
        String string = String.valueOf(number);

        int sum = 0;

        for (int j = 1; j < 10; ++j) {
          if (number % j == 0) {
            sum += string.length() - string.replace(String.valueOf(j), "").length();
          }
        }

        System.out.println(sum);
      }
    }
  }
}
