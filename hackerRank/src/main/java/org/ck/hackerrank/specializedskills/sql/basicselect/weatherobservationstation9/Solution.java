package org.ck.hackerrank.specializedskills.sql.basicselect.weatherobservationstation9;

@org.ck.codechallengelib.annotation.Solution(
    id = 30201014,
    name = "Weather Observation Station 9",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-9",
    category = "SQL",
    subCategory = "Basic Select")
public class Solution {
  public static final String SQL =
      "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, 1, 1) NOT IN ('a', 'e', 'i', 'o', 'u');";
}
