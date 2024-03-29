package org.ck.leetcode.problems.problem1920;

@org.ck.codechallengelib.annotation.Solution(
    id = 101920,
    name = "1920. Build Array from Permutation",
    url = "https://leetcode.com/problems/build-array-from-permutation/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Simulation"})
public class Solution {
  public int[] buildArray(final int[] nums) {
    final int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; ++i) {
      result[i] = nums[nums[i]];
    }

    return result;
  }
}
