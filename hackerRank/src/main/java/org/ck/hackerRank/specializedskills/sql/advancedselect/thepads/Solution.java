package org.ck.hackerRank.specializedskills.sql.advancedselect.thepads;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30202002,
		name = "The PADS",
		url = "https://www.hackerrank.com/challenges/the-pads",
		category = "SQL",
		subCategory = "Advanced Select",
		solved = false
)
public class Solution
{
	public static final String SQL = "SELECT CONCAT(name, '(', SUBSTRING(occupation, 1, 1), ')') FROM occupations ORDER BY name;";
}