package org.ck.hackerrank.specializedskills.sql.basicselect.revisingtheselectqueryii;

@org.ck.codechallengelib.annotation.Solution(
    id = 30201002,
    name = "Revising the Select Query II",
    url = "https://www.hackerrank.com/challenges/revising-the-select-query-2",
    category = "SQL",
    subCategory = "Basic Select")
public class Solution {
  public static final String SQL =
      "SELECT name FROM city WHERE countrycode = 'USA' AND population > 120000;";
}
