package org.ck.hackerRank.languages.java.strings.stringreverse;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202004,
    name = "Java String Reverse",
    url = "https://www.hackerrank.com/challenges/java-string-reverse",
    category = "Java",
    subCategory = "Strings")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNext()) {
        String string = in.nextLine();

        boolean isPalindrome = true;

        for (int i = 0; i < string.length() / 2; ++i) {
          if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
            isPalindrome = false;
            break;
          }
        }

        System.out.println(isPalindrome ? "Yes" : "No");
      }
    }
  }
}
