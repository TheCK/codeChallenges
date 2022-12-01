package org.ck.leetcode.problems.problem1689;

import java.util.Arrays;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101689,
    name = "1689. Partitioning Into Minimum Number Of Deci-Binary Numbers",
    url = "https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/",
    category = "Problems")
public class Solution {
  public int minPartitions(String n) {
    return Arrays.stream(n.split("")).mapToInt(Integer::parseInt).max().getAsInt();
  }
}
