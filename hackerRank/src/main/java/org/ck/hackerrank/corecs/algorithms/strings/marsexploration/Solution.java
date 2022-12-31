package org.ck.hackerrank.corecs.algorithms.strings.marsexploration;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10305,
    name = "Mars Exploration",
    url = "https://www.hackerrank.com/challenges/mars-exploration",
    category = "Algorithms",
    subCategory = "Strings")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String string = in.next();

      int changed = 0;
      for (int i = 0; i < string.length(); i += 3) {
        if (string.charAt(i) != 'S') {
          ++changed;
        }
        if (string.charAt(i + 1) != 'O') {
          ++changed;
        }
        if (string.charAt(i + 2) != 'S') {
          ++changed;
        }
      }

      System.out.println(changed);
    }
  }
}
