package org.ck.hackerrank.corecs.algorithms.strings.twostrings;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10320,
    name = "Two Strings",
    url = "https://www.hackerrank.com/challenges/two-strings",
    category = "Algorithms",
    subCategory = "Strings")
public class Solution {
  public static void main(String[] args) {
    List<String> letters =
        Arrays.asList(
            new String[] {
              "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
              "r", "s", "t", "u", "v", "w", "x", "y", "z"
            });

    try (Scanner in = new Scanner(System.in)) {
      int cases = in.nextInt();
      in.nextLine();

      for (int i = 0; i < cases; ++i) {
        String word1 = in.nextLine().trim();
        String word2 = in.nextLine().trim();

        boolean commonSubstring = false;

        for (String letter : letters) {
          if (word1.contains(letter) && word2.contains(letter)) {
            commonSubstring = true;
            break;
          }
        }

        System.out.println(commonSubstring ? "YES" : "NO");
      }
    }
  }
}
