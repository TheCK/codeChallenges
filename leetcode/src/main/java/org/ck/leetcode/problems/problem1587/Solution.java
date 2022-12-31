package org.ck.leetcode.problems.problem1587;

@org.ck.codechallengelib.annotation.Solution(
    id = 101587,
    name = "1587. Bank Account Summary II",
    url = "https://leetcode.com/problems/bank-account-summary-ii/",
    category = "Problems")
public class Solution {
  public static final String SQL =
      "select name, sum(amount) balance from Users u join Transactions t on u.account = t.account group by u.account having balance > 10000;";
}
