package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation17;

@org.ck.codechallengelib.annotation.Solution(
    id = 30203014,
    name = "Weather Observation Station 17",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-17",
    category = "SQL",
    subCategory = "Aggregation")
public class Solution {
  public static final String SQL =
      "SELECT ROUND(long_w, 4) FROM station WHERE lat_n > 38.778 ORDER BY lat_n ASC limit 1;";
}
