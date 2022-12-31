package org.ck.hackerrank.specializedskills.sql.advancedselect.thepads;

@org.ck.codechallengelib.annotation.Solution(
		id = 30202002,
		name = "The PADS",
		url = "https://www.hackerrank.com/challenges/the-pads",
		category = "SQL",
		subCategory = "Advanced Select"
)
public class Solution
{
	public static final String SQL = "SELECT CONCAT(name, '(', SUBSTRING(occupation, 1, 1), ')') text FROM occupations order by text;"
			+ "SELECT CONCAT('There are total ', COUNT(*), ' ', LOWER(occupation), 's.') text FROM occupations GROUP BY occupation ORDER BY COUNT(*), text;";
}