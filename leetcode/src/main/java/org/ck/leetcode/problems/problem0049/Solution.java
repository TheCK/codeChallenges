package org.ck.leetcode.problems.problem0049;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(
    id = 100049,
    name = "49. Group Anagrams",
    url = "https://leetcode.com/problems/group-anagrams",
    category = "Problems",
    subCategory = "Medium",
    tags = {"Array", "Hash Table", "String", "Sorting"})
public class Solution {
  public List<List<String>> groupAnagrams(final String[] strs) {
    return Arrays.stream(strs)
        .map(
            str ->
                new Stats(
                    str,
                    str.chars()
                        .boxed()
                        .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))))
        .collect(Collectors.groupingBy(Stats::letterCounts))
        .values()
        .stream()
        .map(group -> group.stream().map(Stats::str).toList())
        .toList();
  }

  record Stats(String str, Map<Integer, Long> letterCounts) {}
}
