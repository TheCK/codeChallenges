package org.ck.leetcode.problems.problem1952;

@org.ck.codechallengelib.annotation.Solution(
    id = 101952,
    name = "1952. Three Divisors",
    url = "https://leetcode.com/problems/three-divisors/",
    category = "Problems")
public class Solution {
  public boolean isThree(int n) {
    int divisors = 0;

    for (int i = 1; i < Math.sqrt(n); ++i) {
      if (n % i == 0) {
        divisors += 2;
      }
    }

    if (n % Math.sqrt(n) == 0) {
      ++divisors;
    }

    return divisors == 3;
  }
}
