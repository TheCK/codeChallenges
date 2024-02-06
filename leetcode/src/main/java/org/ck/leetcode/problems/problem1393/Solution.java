package org.ck.leetcode.problems.problem1393;

@org.ck.codechallengelib.annotation.Solution(
    id = 101393,
    name = "1393. Capital Gain/Loss",
    url = "https://leetcode.com/problems/capital-gainloss/",
    category = "Problems",
    subCategory = "Medium",
    tags = {"Database"})
public class Solution {
  public static final String SQL =
      "select stock_name, sum(case when operation = 'Buy' then -price else price end) capital_gain_loss from Stocks group by stock_name;";
}
