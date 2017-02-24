package org.ck.hackerRank.algorithms.implementation.nondivisiblesubset;

import java.util.Arrays;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10221,
		name = "Non-Divisible Subset",
		url = "https://www.hackerrank.com/challenges/non-divisible-subset",
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

			int[] array = new int[n];
			for (int i = 0; i < n; ++i)
			{
				array[i] = in.nextInt();
			}

			int[] remainders = new int[k];
			Arrays.fill(remainders, 0);
			for (int i = 0; i < n; ++i)
			{
				remainders[array[i] % k]++;
			}

			int size = 0;
			for (int i = 1; 2 * i < k; ++i)
			{
				size += Math.max(remainders[i], remainders[k - i]);
			}
			if (remainders[0] > 0)
			{
				++size;
			}
			if (k % 2 == 0 && remainders[k / 2] > 0)
			{
				++size;
			}

			System.out.println(size);
		}
	}
}