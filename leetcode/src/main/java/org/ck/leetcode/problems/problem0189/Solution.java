package org.ck.leetcode.problems.problem0189;

@org.ck.codechallengelib.annotation.Solution(
    id = 100189,
    name = "189. Rotate Array",
    url = "https://leetcode.com/problems/rotate-array",
    category = "Problems",
    subCategory = "Medium",
    tags = {"Array", "Math", "Two Pointers"})
public class Solution {
  public void rotate(final int[] nums, final int k) {
    if (k == 0 || nums.length < 2 || k % nums.length == 0) {
      return;
    }

    final int shift = k % nums.length;
    final int cycles = gcd(nums.length, k);

    for (int cycle = 0; cycle < cycles; ++cycle) {
      int index = cycle;
      int current = nums[index];

      for (int i = 0; i < nums.length / cycles; ++i) {
        index = (index + shift) % nums.length;

        final int tmp = nums[index];
        nums[index] = current;
        current = tmp;
      }
    }
  }

  private int gcd(final int one, final int two) {
    if (two == 0) {
      return one;
    }

    return gcd(two, one % two);
  }
}
