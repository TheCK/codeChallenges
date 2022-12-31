package org.ck.hackerrank.specializedskills.sql.basicjoin.thereport;

@org.ck.codechallengelib.annotation.Solution(
    id = 30204004,
    name = "The Report",
    url = "https://www.hackerrank.com/challenges/the-report",
    category = "SQL",
    subCategory = "Basic Join")
public class Solution {
  public static final String SQL =
      "SELECT CASE WHEN g.grade >= 8 THEN s.name ELSE 'NULL' END, g.grade, s.marks FROM students s JOIN grades g ON s.marks >= g.min_mark AND s.marks <= g.max_mark ORDER BY g.grade DESC, s.name;";
}
