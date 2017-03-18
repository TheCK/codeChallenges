package org.ck.hackerRank.corecs.algorithms.decommissioned.solvemesecond;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 19901,
		name = "Solve me second",
		url = "https://www.hackerrank.com/challenges/solve-me-second",
		category = "Algorithms",
		subCategory = "Decommissioned"
)
public class Solution
{
	static int sum(int a, int b)
	{
		return a + b;
	}

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int max = in.nextInt();

			for (int i = 1; i <= max; ++i)
			{
				int a = in.nextInt();
				int b = in.nextInt();

				System.out.println(sum(a, b));
			}
		}
	}
}