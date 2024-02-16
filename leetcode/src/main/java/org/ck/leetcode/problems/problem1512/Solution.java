package org.ck.leetcode.problems.problem1512;

import java.util.HashMap;
import java.util.Map;

@org.ck.codechallengelib.annotation.Solution(
    id = 101512,
    name = "1512. Number of Good Pairs",
    url = "https://leetcode.com/problems/number-of-good-pairs",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "Hash Table", "Math", "Counting"})
public class Solution {
  public int numIdenticalPairs(final int[] nums) {
    final Map<Integer, Integer> seenNumber = new HashMap<>();
    int goodPairs = 0;

    for (final int num : nums) {
      final int previousSeenCount = seenNumber.getOrDefault(num, 0);

      goodPairs += previousSeenCount;
      seenNumber.put(num, previousSeenCount + 1);
    }

    return goodPairs;
  }
}
