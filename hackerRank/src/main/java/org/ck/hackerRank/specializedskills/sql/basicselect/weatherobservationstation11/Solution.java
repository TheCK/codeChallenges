package org.ck.hackerRank.specializedskills.sql.basicselect.weatherobservationstation11;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30201016,
		name = "Weather Observation Station 11",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-11",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, 1, 1) NOT IN ('a', 'e', 'i', 'o', 'u') OR SUBSTRING(city, LENGTH(city), 1) NOT IN ('a', 'e', 'i', 'o', 'u');";
}