package org.ck.leetcode.problems.problem0027;

@org.ck.codechallengelib.annotation.Solution(
    id = 100027,
    name = "27. Remove Element",
    url = "https://leetcode.com/problems/remove-element/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Two Pointers"})
public class Solution {
  public int removeElement(final int[] nums, final int val) {
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
