package org.ck.leetcode.problems.problem1741;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101741,
    name = "1741. Find Total Time Spent by Each Employee",
    url = "https://leetcode.com/problems/find-total-time-spent-by-each-employee/",
    category = "Problems")
public class Solution {
  public static final String SQL =
      "select event_day day, emp_id, sum(out_time - in_time) total_time from Employees group by day, emp_id;";
}
