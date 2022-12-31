package org.ck.hackerrank.languages.java.introduction.staticinitializerblock;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40201010,
    name = "Java Static Initializer Block",
    url = "https://www.hackerrank.com/challenges/java-static-initializer-block",
    category = "Java",
    subCategory = "Introduction")
public class Solution {
  private static boolean flag = true;
  private static int B;
  private static int H;

  static {
    try (Scanner in = new Scanner(System.in)) {
      B = in.nextInt();
      H = in.nextInt();

      if (B <= 0 || H <= 0) {
        flag = false;
        System.out.println("java.lang.Exception: Breadth and height must be positive");
      }
    }
  }

  public static void main(String[] args) {
    if (flag) {
      int area = B * H;
      System.out.println(area);
    }
  }
}
