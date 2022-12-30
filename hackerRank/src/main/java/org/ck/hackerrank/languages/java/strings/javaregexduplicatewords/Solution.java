package org.ck.hackerrank.languages.java.strings.javaregexduplicatewords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202009,
    name = "Java Regex 2 - Duplicate Words",
    url = "https://www.hackerrank.com/challenges/duplicate-word",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  public static void main(String[] args) {
    String regex = "\\b(\\w+)(\\s+(?i:\\1)\\b)+";
    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    try (Scanner in = new Scanner(System.in)) {
      int numSentences = Integer.parseInt(in.nextLine());

      while (numSentences-- > 0) {
        String input = in.nextLine();

        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
          input = input.replaceAll(regex, "$1");
        }

        // Prints the modified sentence.
        System.out.println(input);
      }
    }
  }
}
