package org.ck.hackerrank.specializedskills.sql.aggregation.theblunder;

@org.ck.codechallengelib.annotation.Solution(
		id = 30203007,
		name = "The Blunder",
		url = "https://www.hackerrank.com/challenges/the-blunder",
		category = "SQL",
		subCategory = "Aggregation"
)
public class Solution
{
	public static final String SQL = "SELECT CEIL(AVG(salary) - AVG(REPLACE(salary, '0', ''))) FROM employees;";
}