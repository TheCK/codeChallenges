package org.ck.hackerrank.corecs.mathematics.fundamentals.fillingjars;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 30119,
		name = "Filling Jars",
		url = "https://www.hackerrank.com/challenges/filling-jars",
		category = "Mathematics",
		subCategory = "Fundamentals"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int jars = in.nextInt();
			int operations = in.nextInt();

			long totalCandies = 0;

			for (int i = 0; i < operations; ++i)
			{
				long start = in.nextInt();
				long end = in.nextInt();
				long candies = in.nextInt();

				totalCandies += (end - start + 1) * candies;
			}

			System.out.println(totalCandies / jars);
		}
	}
}