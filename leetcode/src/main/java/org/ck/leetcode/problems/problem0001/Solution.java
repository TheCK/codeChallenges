package org.ck.leetcode.problems.problem0001;

import java.util.HashMap;
import java.util.Map;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 100001,
    name = "1. Two Sum",
    url = "https://leetcode.com/problems/two-sum",
    category = "Problems")
public class Solution {
  private final Map<Integer, Integer> numberCache = new HashMap<>();

  public int[] twoSum(int[] nums, int target) {
    int i = 0;

    while (i < nums.length) {
      int currentIndex = i;
      int currentValue = nums[currentIndex];

      if (numberCache.containsKey(target - currentValue)) {
        return new int[] {numberCache.get(target - currentValue), currentIndex};
      }

      numberCache.computeIfAbsent(currentValue, key -> currentIndex);

      ++i;
    }

    return null;
  }
}
