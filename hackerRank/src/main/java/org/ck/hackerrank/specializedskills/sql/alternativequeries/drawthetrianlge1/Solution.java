package org.ck.hackerrank.specializedskills.sql.alternativequeries.drawthetrianlge1;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30206001,
		name = "Draw The Triangle 1",
		url = "https://www.hackerrank.com/challenges/draw-the-triangle-1",
		category = "SQL",
		subCategory = "Alternative Queries",
		solved = false
)
public class Solution
{
	public static final String SQL = "set i=20;"
			+ "while i>0 do"
			+ "    select REPEAT(\"*\", i);"
			+ "    set i= i-1;"
			+ "end while;";
}