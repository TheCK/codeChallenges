package org.ck.leetcode.problems.problem1979;

import java.util.Arrays;

@org.ck.codechallengelib.annotation.Solution(
    id = 101979,
    name = "1979. Find Greatest Common Divisor of Array",
    url = "https://leetcode.com/problems/find-greatest-common-divisor-of-array/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Math", "Number Theory"})
public class Solution {
  public int findGCD(final int[] nums) {
    final var stats = Arrays.stream(nums).summaryStatistics();

    return gcd(stats.getMin(), stats.getMax());
  }

  private static int gcd(final int one, final int two) {
    if (two == 0) return one;
    return gcd(two, one % two);
  }
}
