package org.ck.hackerRank.languages.java.strings.tagcontentextractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40202011,
    name = "Tag Content Extractor",
    url = "https://www.hackerrank.com/challenges/tag-content-extractor",
    category = "Java",
    subCategory = "Strings")
public class Solution {

  public static void main(String[] args) {
    Pattern p = Pattern.compile("<([^>]+)>([^<]+)</\\1>");

    try (Scanner in = new Scanner(System.in)) {
      int testCases = Integer.parseInt(in.nextLine());
      while (testCases > 0) {
        String line = in.nextLine();

        Matcher matcher = p.matcher(line);

        boolean found = false;
        while (matcher.find()) {
          System.out.println(matcher.group(2));
          found = true;
        }

        if (!found) {
          System.out.println("None");
        }

        testCases--;
      }
    }
  }
}
