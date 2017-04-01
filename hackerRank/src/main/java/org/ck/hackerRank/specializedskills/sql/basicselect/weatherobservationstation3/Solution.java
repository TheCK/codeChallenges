package org.ck.hackerRank.specializedskills.sql.basicselect.weatherobservationstation3;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30201008,
		name = "Weather Observation Station 3",
		url = "https://www.hackerrank.com/challenges/weather-observation-station-3",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT DISTINCT(city) FROM station WHERE id MOD 2 = 0;";
}