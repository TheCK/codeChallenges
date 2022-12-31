package org.ck.leetcode.problems.problem1693;

@org.ck.codechallengelib.annotation.Solution(
    id = 101693,
    name = "1693. Daily Leads and Partners",
    url = "https://leetcode.com/problems/daily-leads-and-partners/",
    category = "Problems")
public class Solution {
  public static final String SQL =
      "select date_id, make_name, count(distinct lead_id) unique_leads, count(distinct partner_id) unique_partners from DailySales group by date_id, make_name;";
}
