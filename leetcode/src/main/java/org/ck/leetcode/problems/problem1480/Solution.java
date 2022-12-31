package org.ck.leetcode.problems.problem1480;

@org.ck.codechallengelib.annotation.Solution(
    id = 101480,
    name = "1480. Running Sum of 1d Array",
    url = "https://leetcode.com/problems/running-sum-of-1d-array/",
    category = "Problems")
public class Solution {
  public int[] runningSum(int[] nums) {
    int[] out = new int[nums.length];
    int sum = 0;

    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      out[i] = sum;
    }

    return out;
  }
}
