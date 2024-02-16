package org.ck.leetcode.problems.problem0026;

@org.ck.codechallengelib.annotation.Solution(
    id = 100026,
    name = "26. Remove Duplicates from Sorted Array",
    url = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Two Pointers"})
public class Solution {
  public int removeDuplicates(final int[] nums) {
    int read = 0;
    int write = 0;
    int last = Integer.MIN_VALUE;

    while (read < nums.length) {
      if (nums[read] != last) {
        nums[write] = nums[read];
        ++write;

        last = nums[read];
      }
      ++read;
    }

    return write;
  }
}
