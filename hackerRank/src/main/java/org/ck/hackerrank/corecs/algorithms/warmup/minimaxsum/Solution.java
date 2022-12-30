package org.ck.hackerrank.corecs.algorithms.warmup.minimaxsum;

import java.util.Arrays;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10108,
		name = "Mini-Max Sum",
		url = "https://www.hackerrank.com/challenges/mini-max-sum",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	private static int NUMBER_COUNT = 5;

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			long minimum = Long.MAX_VALUE;
			long maximum = 0L;

			long[] numbers = new long[NUMBER_COUNT];
			for (int i = 0; i < NUMBER_COUNT; ++i)
			{
				long current = in.nextLong();

				if (current > maximum)
				{
					maximum = current;
				}

				if (current < minimum)
				{
					minimum = current;
				}

				numbers[i] = current;
			}

			long sum = Arrays.stream(numbers).sum();
			System.out.println(String.format("%d %d", sum - maximum, sum - minimum));
		}
	}
}