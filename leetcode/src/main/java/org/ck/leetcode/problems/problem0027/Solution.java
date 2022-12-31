package org.ck.leetcode.problems.problem0027;

@org.ck.codechallengelib.annotation.Solution(
    id = 100027,
    name = "27. Remove Element",
    url = "https://leetcode.com/problems/remove-element/",
    category = "Problems")
public class Solution {
  public int removeElement(int[] nums, int val) {
    int write = 0;
    int read = nums.length - 1;

    while (write <= read) {
      if (nums[write] == val) {
        nums[write] = nums[read];
        --read;

        if (nums[write] == val) {
          --write;
        }
      }
      ++write;
    }

    return write;
  }
}
