package org.ck.hackerrank.corecs.algorithms.implementation.minimumdistances;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10242,
		name = "Minimum Distances",
		url = "https://www.hackerrank.com/challenges/minimum-distances",
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

			int[] array = new int[n];
			for (int i = 0; i < n; ++i)
			{
				array[i] = in.nextInt();
			}

			int minimum = Integer.MAX_VALUE;
			for (int i = 0; i < n - 1; ++i)
			{
				for (int j = i + 1; j < n; ++j)
				{
					if (array[i] == array[j])
					{
						minimum = Math.min(minimum, j - i);
					}
				}
			}

			System.out.println(minimum == Integer.MAX_VALUE ? -1 : minimum);
		}
	}
}