package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation19;

@org.ck.codechallengelib.annotation.Solution(
    id = 30203016,
    name = "Weather Observation Station 19",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-19",
    category = "SQL",
    subCategory = "Aggregation")
public class Solution {
  public static final String SQL =
      "SELECT ROUND(SQRT(POW(MAX(lat_n) - MIN(lat_n), 2) + POW(MAX(long_w) - MIN(long_w), 2)), 4) FROM station;";
}
