package org.ck.hackerrank.specializedskills.sql.aggregation.averagepopulation;

@org.ck.codechallengelib.annotation.Solution(
		id = 30203004,
		name = "Average Population",
		url = "https://www.hackerrank.com/challenges/average-population",
		category = "SQL",
		subCategory = "Aggregation"
)
public class Solution
{
	public static final String SQL = "SELECT FLOOR(AVG(population)) FROM city;";
}