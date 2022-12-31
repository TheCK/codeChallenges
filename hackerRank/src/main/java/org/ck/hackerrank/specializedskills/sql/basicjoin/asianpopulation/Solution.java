package org.ck.hackerrank.specializedskills.sql.basicjoin.asianpopulation;

@org.ck.codechallengelib.annotation.Solution(
		id = 30204001,
		name = "Asian Population",
		url = "https://www.hackerrank.com/challenges/asian-population",
		category = "SQL",
		subCategory = "Basic Join"
)
public class Solution
{
	public static final String SQL = "SELECT SUM(ci.population) FROM city ci JOIN country co on ci.countrycode = co.code WHERE continent = 'Asia';";
}