package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation13;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30203010,
		name = "Weather Observation Station 13",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-13",
		category = "SQL",
		subCategory = "Aggregation"
)
public class Solution
{
	public static final String SQL = "SELECT ROUND(SUM(lat_n), 4) lat FROM station WHERE lat_n > 38.788 AND lat_n < 137.2345;";
}