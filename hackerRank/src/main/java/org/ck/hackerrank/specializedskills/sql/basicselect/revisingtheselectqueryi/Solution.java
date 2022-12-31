package org.ck.hackerrank.specializedskills.sql.basicselect.revisingtheselectqueryi;

@org.ck.codechallengelib.annotation.Solution(
    id = 30201001,
    name = "Revising the Select Query I",
    url = "https://www.hackerrank.com/challenges/revising-the-select-query",
    category = "SQL",
    subCategory = "Basic Select")
public class Solution {
  public static final String SQL =
      "SELECT * FROM city WHERE countrycode = 'USA' AND population > 100000;";
}
