package org.ck.leetcode.problems.problem0151;

import java.util.ArrayList;
import java.util.List;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 100151,
    name = "151. Reverse Words in a String",
    url = "https://leetcode.com/problems/reverse-words-in-a-string/",
    category = "Problems")
public class Solution {
  public String reverseWords(String s) {
    String[] split = s.split(" ");
    List<String> reverse = new ArrayList<>();

    for (int i = split.length - 1; i >= 0; --i) {
      if (!split[i].isEmpty()) {
        reverse.add(split[i]);
      }
    }

    return String.join(" ", reverse);
  }
}
