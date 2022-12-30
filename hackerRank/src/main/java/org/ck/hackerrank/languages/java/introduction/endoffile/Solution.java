package org.ck.hackerrank.languages.java.introduction.endoffile;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40201009,
		name = "Java End-of-file",
		url = "https://www.hackerrank.com/challenges/java-end-of-file",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = 1;

			while (in.hasNext())
			{
				System.out.println(String.format("%d %s", count++, in.nextLine()));
			}
		}
	}
}