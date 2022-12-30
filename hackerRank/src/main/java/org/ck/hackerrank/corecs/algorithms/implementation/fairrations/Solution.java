package org.ck.hackerrank.corecs.algorithms.implementation.fairrations;

import java.util.Arrays;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10248,
		name = "Fair Rations",
		url = "https://www.hackerrank.com/challenges/fair-rations",
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

			long odds = getOddNumberCount(array);

			if (odds % 2 != 0)
			{
				System.out.println("NO");
			}
			else
			{
				int count = 0;
				while (getOddNumberCount(array) > 0)
				{
					int index = getFirstOddIndex(array);
					System.err.println(index);
					array[index]++;
					array[index + 1]++;

					++count;
				}

				System.out.println(2 * count);
			}
		}
	}

	private static int getFirstOddIndex(int[] array)
	{
		for (int i = 0; i < array.length; ++i)
		{
			if (array[i] % 2 != 0)
			{
				return i;
			}
		}

		return -1;
	}

	private static long getOddNumberCount(int[] array)
	{
		return Arrays.stream(array)
				.filter(number -> number % 2 != 0)
				.count();
	}
}