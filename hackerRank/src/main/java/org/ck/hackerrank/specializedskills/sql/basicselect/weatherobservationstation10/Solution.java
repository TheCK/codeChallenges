package org.ck.hackerrank.specializedskills.sql.basicselect.weatherobservationstation10;

@org.ck.codechallengelib.annotation.Solution(
		id = 30201015,
		name = "Weather Observation Station 10",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-10",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, LENGTH(city), 1) NOT IN ('a', 'e', 'i', 'o', 'u');";
}