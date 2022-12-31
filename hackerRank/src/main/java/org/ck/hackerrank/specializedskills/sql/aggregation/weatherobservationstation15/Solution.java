package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation15;

@org.ck.codechallengelib.annotation.Solution(
		id = 30203012,
		name = "Weather Observation Station 15",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-15",
		category = "SQL",
		subCategory = "Aggregation"
)
public class Solution
{
	public static final String SQL = "SELECT ROUND(long_w, 4) FROM station WHERE lat_n < 137.2345 ORDER BY lat_n DESC limit 1;";
}