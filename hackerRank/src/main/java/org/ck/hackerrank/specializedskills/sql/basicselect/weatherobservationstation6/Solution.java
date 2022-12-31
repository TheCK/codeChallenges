package org.ck.hackerrank.specializedskills.sql.basicselect.weatherobservationstation6;

@org.ck.codechallengelib.annotation.Solution(
		id = 30201011,
		name = "Weather Observation Station 6",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-6",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, 1, 1) IN ('a', 'e', 'i', 'o', 'u');";
}