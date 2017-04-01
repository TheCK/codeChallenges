package org.ck.hackerRank.specializedskills.sql.basicselect.weatherobservationstation12;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30201017,
		name = "Weather Observation Station 12",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-12",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, 1, 1) NOT IN ('a', 'e', 'i', 'o', 'u') AND SUBSTRING(city, LENGTH(city), 1) NOT IN ('a', 'e', 'i', 'o', 'u');";
}