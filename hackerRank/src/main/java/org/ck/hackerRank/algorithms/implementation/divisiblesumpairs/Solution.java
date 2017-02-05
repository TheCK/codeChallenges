package org.ck.hackerRank.algorithms.implementation.divisiblesumpairs;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10206,
		name = "Divisible Sum Pairs",
		url = "https://www.hackerrank.com/challenges/divisible-sum-pairs",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();
			int k = in.nextInt();

			int[] numbers = new int[n];
			for (int i = 0; i < n; ++i)
			{
				numbers[i] = in.nextInt();
			}

			int count = 0;
			for (int i = 0; i < n - 1; ++i)
			{
				for (int j = i + 1; j < n; ++j)
				{
					if ((numbers[i] + numbers[j]) % k == 0)
					{
						++count;
					}
				}
			}

			System.out.println(count);
		}
	}
}