package org.ck.hackerrank.specializedskills.sql.advancedselect.typeoftriangle;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30202001,
		name = "Type of Triangle",
		url = "https://www.hackerrank.com/challenges/what-type-of-triangle",
		category = "SQL",
		subCategory = "Advanced Select"
)
public class Solution
{
	public static final String SQL = "SELECT\n"
			+ "    CASE\n"
			+ "        WHEN (a + b) <= c OR (b + c) <= a OR (a + c) <= b THEN 'Not A Triangle'\n"
			+ "        WHEN a = b AND b = c THEN 'Equilateral'\n"
			+ "        WHEN a = b OR b = c OR a = c THEN 'Isosceles'\n"
			+ "        ELSE 'Scalene'\n"
			+ "    END\n"
			+ "FROM triangles;";
}