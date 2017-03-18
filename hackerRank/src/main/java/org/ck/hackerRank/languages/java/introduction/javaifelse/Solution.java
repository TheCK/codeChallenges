package org.ck.hackerRank.languages.java.introduction.javaifelse;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40201003,
		name = "Java If-Else",
		url = "https://www.hackerrank.com/challenges/java-if-else",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int number = scan.nextInt();
		boolean isWeird = true;

		if (number % 2 == 0)
		{
			if (number == 4 || number > 20)
			{
				isWeird = false;
			}
		}

		System.out.println(isWeird ? "Weird" : "Not Weird");
	}
}