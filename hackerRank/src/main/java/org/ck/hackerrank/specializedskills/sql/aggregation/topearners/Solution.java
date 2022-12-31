package org.ck.hackerrank.specializedskills.sql.aggregation.topearners;

@org.ck.codechallengelib.annotation.Solution(
    id = 30203008,
    name = "Top Earners",
    url = "https://www.hackerrank.com/challenges/earnings-of-employees",
    category = "SQL",
    subCategory = "Aggregation")
public class Solution {
  public static final String SQL =
      "SELECT months * salary total, count(*) c FROM employee GROUP BY total ORDER BY total DESC limit 1;";
}
