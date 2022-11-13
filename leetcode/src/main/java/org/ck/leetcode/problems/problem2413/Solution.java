package org.ck.leetcode.problems.problem2413;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 102413,
    name = "2413. Smallest Even Multiple",
    url = "https://leetcode.com/problems/smallest-even-multiple/",
    category = "Problems")
public class Solution {
  public int smallestEvenMultiple(int n) {
    return n % 2 == 0 ? n : 2 * n;
  }
}
