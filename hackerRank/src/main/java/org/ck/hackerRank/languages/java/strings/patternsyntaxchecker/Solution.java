package org.ck.hackerRank.languages.java.strings.patternsyntaxchecker;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202007,
    name = "Pattern Syntax Checker",
    url = "https://www.hackerrank.com/challenges/pattern-syntax-checker",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int testCases = Integer.parseInt(in.nextLine());

      while (testCases > 0) {
        String pattern = in.nextLine();

        try {
          Pattern.compile(pattern);
          System.out.println("Valid");
        } catch (PatternSyntaxException e) {
          System.out.println("Invalid");
        }

        --testCases;
      }
    }
  }
}
