package org.ck.leetcode.problems.problem2413;

@org.ck.codechallengelib.annotation.Solution(
    id = 102413,
    name = "2413. Smallest Even Multiple",
    url = "https://leetcode.com/problems/smallest-even-multiple/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Math", "Number Theory"})
public class Solution {
  public int smallestEvenMultiple(final int n) {
    return n % 2 == 0 ? n : 2 * n;
  }
}
