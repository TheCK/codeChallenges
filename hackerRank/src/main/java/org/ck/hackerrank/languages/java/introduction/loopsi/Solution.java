package org.ck.hackerrank.languages.java.introduction.loopsi;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 40201006,
		name = "Java Loops I",
		url = "https://www.hackerrank.com/challenges/java-loops-i",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	private static final int MULTIPLES = 10;

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int number = in.nextInt();

			for (int i = 1; i <= MULTIPLES; ++i)
			{
				System.out.println(String.format("%d x %d = %d", number, i, number * i));
			}
		}
	}
}