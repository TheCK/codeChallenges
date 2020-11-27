package org.ck.hackerRank.languages.java.introduction.stdinandstdouti;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40201004,
    name = "Java Stdin and Stdout I",
    url = "https://www.hackerrank.com/challenges/java-stdin-and-stdout-1",
    category = "Java",
    subCategory = "Introduction")
public class Solution {
  public static final int NUMBER = 3;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      for (int i = 0; i < NUMBER; ++i) {
        int number = in.nextInt();
        System.out.println(number);
      }
    }
  }
}
