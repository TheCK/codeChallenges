package org.ck.hackerrank.specializedskills.sql.basicselect.employesalaries;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30201020,
		name = "Employee Salaries",
		url = "https://www.hackerrank.com/challenges/salary-of-employees",
		category = "SQL",
		subCategory = "Basic Select"
)
public class Solution
{
	public static final String SQL = "SELECT name FROM employee WHERE salary > 2000 AND months < 10 ORDER BY employee_id;";
}