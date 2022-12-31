package org.ck.hackerrank.specializedskills.sql.basicselect.japanesecitiesnames;

@org.ck.codechallengelib.annotation.Solution(
    id = 30201006,
    name = "Japanese Cities' Names",
    url = "https://www.hackerrank.com/challenges/japanese-cities-name",
    category = "SQL",
    subCategory = "Basic Select")
public class Solution {
  public static final String SQL = "SELECT name FROM city WHERE countrycode = 'JPN';";
}
