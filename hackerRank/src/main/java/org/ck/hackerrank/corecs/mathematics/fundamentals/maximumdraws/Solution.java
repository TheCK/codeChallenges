package org.ck.hackerrank.corecs.mathematics.fundamentals.maximumdraws;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 30102,
    name = "Maximum Draws",
    url = "https://www.hackerrank.com/challenges/maximum-draws",
    category = "Mathematics",
    subCategory = "Fundamentals")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Integer cases = in.nextInt();

      for (Integer i = 0; i < cases; ++i) {
        Integer numberofSocks = in.nextInt();

        System.out.println(numberofSocks + 1);
      }
    }
  }
}
