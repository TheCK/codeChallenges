package org.ck.hackerRank.specializedskills.sql.basicjoin.averagepopulationofeachcontinent;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30204003,
		name = "Average Population of Each Continent",
		url = "https://www.hackerrank.com/challenges/average-population-of-each-continent",
		category = "SQL",
		subCategory = "Basic Join"
)
public class Solution
{
	public static final String SQL = "SELECT co.continent, FLOOR(AVG(ci.population)) c FROM city ci JOIN country co ON ci.countrycode = co.code GROUP BY co.continent HAVING c > 0;";
}