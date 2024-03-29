package org.ck.leetcode.problems.problem1929;

@org.ck.codechallengelib.annotation.Solution(
    id = 101929,
    name = "1929. Concatenation of Array",
    url = "https://leetcode.com/problems/concatenation-of-array/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Simulation"})
public class Solution {
  public int[] getConcatenation(final int[] nums) {
    final int[] result = new int[nums.length * 2];

    for (int i = 0; i < nums.length; ++i) {
      result[i] = nums[i];
      result[nums.length + i] = nums[i];
    }

    return result;
  }
}
