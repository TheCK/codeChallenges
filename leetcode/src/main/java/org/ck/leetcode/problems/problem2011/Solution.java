package org.ck.leetcode.problems.problem2011;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 102011,
    name = "2011. Final Value of Variable After Performing Operations",
    url = "https://leetcode.com/problems/final-value-of-variable-after-performing-operations/",
    category = "Problems")
public class Solution {
  public int finalValueAfterOperations(String[] operations) {
    int x = 0;

    for (String operation : operations) {
      switch (operation) {
        case "X++", "++X" -> ++x;
        case "X--", "--X" -> --x;
      }
    }

    return x;
  }
}