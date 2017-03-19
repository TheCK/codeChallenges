package org.ck.hackerRank.languages.java.strings.substring;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40202002,
		name = "Java Substring",
		url = "https://www.hackerrank.com/challenges/java-substring",
		category = "Java",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String string = in.nextLine();
			Integer start = in.nextInt();
			Integer end = in.nextInt();

			System.out.println(string.substring(start, end));
		}
	}
}