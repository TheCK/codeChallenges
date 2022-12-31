package org.ck.hackerrank.specializedskills.sql.basicselect.weatherobservationstation8;

@org.ck.codechallengelib.annotation.Solution(
    id = 30201013,
    name = "Weather Observation Station 8",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-8",
    category = "SQL",
    subCategory = "Basic Select")
public class Solution {
  public static final String SQL =
      "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, 1, 1) IN ('a', 'e', 'i', 'o', 'u') AND SUBSTRING(city, LENGTH(city), 1) IN ('a', 'e', 'i', 'o', 'u');";
}
