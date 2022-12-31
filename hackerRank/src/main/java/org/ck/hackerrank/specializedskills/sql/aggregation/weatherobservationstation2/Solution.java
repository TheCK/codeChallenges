package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation2;

@org.ck.codechallengelib.annotation.Solution(
    id = 30203009,
    name = "Weather Observation Station 2",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-2",
    category = "SQL",
    subCategory = "Aggregation")
public class Solution {
  public static final String SQL =
      "SELECT ROUND(SUM(lat_n), 2) lat,  ROUND(SUM(long_w), 2) lon FROM station;";
}
