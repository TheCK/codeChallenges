package org.ck.hackerrank.languages.java.strings.stringtokens;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202006,
    name = "Java String Tokens",
    url = "https://www.hackerrank.com/challenges/java-string-tokens",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String string = in.nextLine();

      String[] tokens = string.split("[ !,?._'@]+");
      int leadingTokenFix = 0;
      if (tokens.length > 0 && "".equals(tokens[0])) {
        leadingTokenFix = 1;
      }

      System.out.println(tokens.length - leadingTokenFix);
      for (int i = leadingTokenFix; i < tokens.length; ++i) {
        System.out.println(tokens[i]);
      }
    }
  }
}
