package org.ck.hackerRank.corecs.algorithms.implementation.servicelane;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10245,
		name = "Service Lane",
		url = "https://www.hackerrank.com/challenges/service-lane",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int laneLength = in.nextInt();
			int testCases = in.nextInt();

			int[] serviceLane = new int[laneLength];
			for (int i = 0; i < laneLength; ++i)
			{
				serviceLane[i] = in.nextInt();
			}

			for (int testCase = 0; testCase < testCases; ++testCase)
			{
				int start = in.nextInt();
				int end = in.nextInt();

				int minimumWidth = 3;
				for (int i = start; i <= end; ++i)
				{
					minimumWidth = Math.min(minimumWidth, serviceLane[i]);
				}

				System.out.println(minimumWidth);
			}
		}
	}
}