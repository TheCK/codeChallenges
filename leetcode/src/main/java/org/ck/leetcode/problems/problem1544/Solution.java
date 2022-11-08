package org.ck.leetcode.problems.problem1544;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101544,
    name = "1544. Make The String Great",
    url = "https://leetcode.com/problems/make-the-string-great/",
    category = "Problems")
public class Solution {
  public String makeGood(String s) {
    boolean isGood;
    StringBuilder builder = new StringBuilder(s);

    do {
      isGood = true;

      for (int i = 0; i < builder.length() - 1; ++i) {
        if ((Character.isLowerCase(builder.charAt(i))
                && Character.toUpperCase(builder.charAt(i)) == builder.charAt(i + 1))
            || (Character.isUpperCase(builder.charAt(i))
                && Character.toLowerCase(builder.charAt(i)) == builder.charAt(i + 1))) {
          builder.delete(i, i + 2);

          isGood = false;
        }
      }
    } while (!isGood);

    return builder.toString();
  }
}
