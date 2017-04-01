package org.ck.hackerRank.specializedskills.sql.basicselect.weatherobservationstation7;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30201012,
		name = "Weather Observation Station 7",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-7",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT DISTINCT(city) FROM station WHERE SUBSTRING(city, LENGTH(city), 1) IN ('a', 'e', 'i', 'o', 'u');";
}