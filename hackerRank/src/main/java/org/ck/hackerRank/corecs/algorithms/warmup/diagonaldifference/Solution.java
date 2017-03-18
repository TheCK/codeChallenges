package org.ck.hackerRank.corecs.algorithms.warmup.diagonaldifference;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10105,
		name = "Diagonal Difference",
		url = "https://www.hackerrank.com/challenges/diagonal-difference",
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

			int[][] array = new int[count][count];
			for (int i = 0; i < count; ++i)
			{
				for (int j = 0; j < count; ++j)
				{
					array[i][j] = in.nextInt();
				}
			}

			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < count; ++i)
			{
				sum1 += array[i][i];
				sum2 += array[i][count - i - 1];
			}

			System.out.println(Math.abs(sum1 - sum2));
		}
	}
}