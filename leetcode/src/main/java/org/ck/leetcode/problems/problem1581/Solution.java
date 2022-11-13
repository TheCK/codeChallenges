package org.ck.leetcode.problems.problem1581;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101581,
    name = "1581. Customer Who Visited but Did Not Make Any Transactions",
    url = "https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/",
    category = "Problems")
public class Solution {
  public static final String SQL =
      "select customer_id, count(*) count_no_trans from Visits v left join Transactions t on v.visit_id = t.visit_id where transaction_id is null group by customer_id;";
}
