package org.ck.leetcode.problems.problem0771;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(
    id = 100771,
    name = "771. Jewels and Stones",
    url = "https://leetcode.com/problems/jewels-and-stones",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Hash Table", "String"})
public class Solution {
  public int numJewelsInStones(final String jewels, final String stones) {
    final Set<Integer> jewelSet = jewels.chars().boxed().collect(Collectors.toSet());

    return (int)
        stones
            .chars()
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> jewelSet.contains(entry.getKey()))
            .mapToLong(Map.Entry::getValue)
            .sum();
  }
}
