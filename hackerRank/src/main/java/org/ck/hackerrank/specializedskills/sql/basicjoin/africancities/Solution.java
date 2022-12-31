package org.ck.hackerrank.specializedskills.sql.basicjoin.africancities;

@org.ck.codechallengelib.annotation.Solution(
		id = 30204002,
		name = "African Cities",
		url = "https://www.hackerrank.com/challenges/african-cities",
		category = "SQL",
		subCategory = "Basic Join"
)
public class Solution
{
	public static final String SQL = "SELECT ci.name FROM city ci JOIN country co on ci.countrycode = co.code WHERE continent = 'Africa';";
}