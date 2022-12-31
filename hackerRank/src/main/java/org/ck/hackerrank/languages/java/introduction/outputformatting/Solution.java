package org.ck.hackerrank.languages.java.introduction.outputformatting;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40201005,
    name = "Java Output Formatting",
    url = "https://www.hackerrank.com/challenges/java-output-formatting",
    category = "Java",
    subCategory = "Introduction")
public class Solution {
  private static final int LINES = 3;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      System.out.println("================================");
      for (int i = 0; i < LINES; ++i) {
        String text = in.next();
        int number = in.nextInt();

        System.out.println(
            String.format(
                String.format(String.format("%%%%s%%%ds%%%%03d", 15 - text.length()), ""),
                text,
                number));
      }
      System.out.println("================================");
    }
  }
}
