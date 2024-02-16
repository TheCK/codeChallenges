package org.ck.leetcode.problems.problem2011;

@org.ck.codechallengelib.annotation.Solution(
    id = 102011,
    name = "2011. Final Value of Variable After Performing Operations",
    url = "https://leetcode.com/problems/final-value-of-variable-after-performing-operations/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Array", "String", "Simulation"})
public class Solution {
  public int finalValueAfterOperations(final String[] operations) {
    int x = 0;

    for (final String operation : operations) {
      switch (operation) {
        case "X++", "++X" -> ++x;
        case "X--", "--X" -> --x;
        default -> throw new IllegalStateException("Unexpected value: " + operation);
      }
    }

    return x;
  }
}
