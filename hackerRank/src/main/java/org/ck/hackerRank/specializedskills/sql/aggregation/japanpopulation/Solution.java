package org.ck.hackerRank.specializedskills.sql.aggregation.japanpopulation;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30203005,
		name = "Japan Population",
		url = "https://www.hackerrank.com/challenges/japan-population",
		category = "SQL",
		subCategory = "Aggregation"
)
public class Solution
{
	public static final String SQL = "SELECT SUM(population) FROM city WHERE countrycode = 'JPN';";
}