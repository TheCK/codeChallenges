package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation18;

@org.ck.codechallengelib.annotation.Solution(
    id = 30203015,
    name = "Weather Observation Station 18",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-18",
    category = "SQL",
    subCategory = "Aggregation")
public class Solution {
  public static final String SQL =
      "SELECT ROUND(MAX(lat_n) - MIN(lat_n) + MAX(long_w) - MIN(long_w), 4) FROM station;";
}
