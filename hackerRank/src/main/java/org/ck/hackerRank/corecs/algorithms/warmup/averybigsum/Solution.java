package org.ck.hackerRank.corecs.algorithms.warmup.averybigsum;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10104,
		name = "A Very Big Sum",
		url = "https://www.hackerrank.com/challenges/a-very-big-sum",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = in.nextInt();

			long sum = 0;
			for (int i = 0; i < count; ++i)
			{
				sum += in.nextLong();
			}

			System.out.println(sum);
		}
	}
}