package org.ck.hackerRank.specializedskills.sql.basicselect.higherthan75marks;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30201018,
		name = "Higher Than 75 Marks",
		url = "https://www.hackerrank.com/challenges/more-than-75-marks",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT name FROM students WHERE marks > 75 ORDER BY SUBSTRING(name, LENGTH(name) - 2, 3), id;";
}