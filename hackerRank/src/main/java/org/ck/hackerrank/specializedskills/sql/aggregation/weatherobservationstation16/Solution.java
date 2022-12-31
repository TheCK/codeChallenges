package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation16;

@org.ck.codechallengelib.annotation.Solution(
    id = 30203013,
    name = "Weather Observation Station 16",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-16",
    category = "SQL",
    subCategory = "Aggregation")
public class Solution {
  public static final String SQL = "SELECT ROUND(MIN(lat_n), 4) FROM station WHERE lat_n > 38.778;";
}
