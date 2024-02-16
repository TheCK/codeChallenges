package org.ck.leetcode.problems.problem0009;

import java.util.ArrayList;
import java.util.List;

@org.ck.codechallengelib.annotation.Solution(
    id = 100009,
    name = "9. Palindrome Number",
    url = "https://leetcode.com/problems/palindrome-number",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Math"})
public class Solution {
  public boolean isPalindrome(int x) {
    if (x >= 0 && x <= 9) {
      return true;
    }

    if (x < 0 || x % 10 == 0) {
      return false;
    }

    final List<Integer> nums = new ArrayList<>();
    while (x != 0) {
      nums.add(x % 10);
      x /= 10;
    }

    for (int i = 0; i < nums.size() / 2; ++i) {
      if (!nums.get(i).equals(nums.get(nums.size() - 1 - i))) {
        return false;
      }
    }

    return true;
  }
}
