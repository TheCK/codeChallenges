package org.ck.leetcode.problems.problem0001;

import java.util.HashMap;
import java.util.Map;

@org.ck.codechallengelib.annotation.Solution(
    id = 100001,
    name = "1. Two Sum",
    url = "https://leetcode.com/problems/two-sum",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Hash Table"})
public class Solution {

  public int[] twoSum(final int[] nums, final int target) {
    final Map<Integer, Integer> numberCache = new HashMap<>();
    int i = 0;

    while (i < nums.length) {
      final int currentIndex = i;
      final int currentValue = nums[currentIndex];

      if (numberCache.containsKey(target - currentValue)) {
        return new int[] {numberCache.get(target - currentValue), currentIndex};
      }

      numberCache.computeIfAbsent(currentValue, key -> currentIndex);

      ++i;
    }

    return null;
  }
}
