package org.ck.leetcode.problems.problem1757;

@org.ck.codechallengelib.annotation.Solution(
    id = 101757,
    name = "1757. Recyclable and Low Fat Products",
    url = "https://leetcode.com/problems/recyclable-and-low-fat-products/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Database"})
public class Solution {
  public static final String SQL =
      "select product_id from Products where low_fats = 'Y' and recyclable = 'Y';";
}
