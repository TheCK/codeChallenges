package org.ck.hackerRank.languages.java.strings.validusernameregularexpression;

import java.util.Scanner;
import java.util.regex.Pattern;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202010,
    name = "Valid Username Regular Expression",
    url = "https://www.hackerrank.com/challenges/valid-username-checker",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  public static void main(String[] args) {
    String regex = "\\b(\\w+)(\\s+(?i:\\1)\\b)+";
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    try (Scanner in = new Scanner(System.in)) {
      int n = Integer.parseInt(in.nextLine());
      while (n-- != 0) {
        String userName = in.nextLine();

        if (userName.matches(UsernameValidator.regularExpression)) {
          System.out.println("Valid");
        } else {
          System.out.println("Invalid");
        }
      }
    }
  }

  private static class UsernameValidator {
    public static final String regularExpression = "[a-zA-Z][a-zA-Z0-9_]{7,29}";
  }
}
