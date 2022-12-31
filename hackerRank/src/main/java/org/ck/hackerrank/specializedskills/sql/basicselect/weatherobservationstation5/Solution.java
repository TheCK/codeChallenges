package org.ck.hackerrank.specializedskills.sql.basicselect.weatherobservationstation5;

@org.ck.codechallengelib.annotation.Solution(
    id = 30201010,
    name = "Weather Observation Station 5",
    url = "https://www.hackerrank.com/challenges/weather-observation-station-5",
    category = "SQL",
    subCategory = "Basic Select")
public class Solution {
  public static final String SQL =
      "SELECT city, LENGTH(city) FROM station ORDER BY LENGTH(city) ASC, city ASC LIMIT 1;\n"
          + "SELECT city, LENGTH(city) FROM station ORDER BY LENGTH(city) DESC, city ASC LIMIT 1;";
}
