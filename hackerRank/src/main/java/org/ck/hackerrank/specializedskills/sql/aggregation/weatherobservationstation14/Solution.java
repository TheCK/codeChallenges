package org.ck.hackerrank.specializedskills.sql.aggregation.weatherobservationstation14;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30203011,
		name = "Weather Observation Station 14",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-14",
		category = "SQL",
		subCategory = "Aggregation"
)
public class Solution
{
	public static final String SQL = "SELECT ROUND(MAX(lat_n), 4) lat FROM station WHERE lat_n < 137.2345;";
}