package org.ck.hackerrank.corecs.datastructures.arrays.arraymanipulation;

import java.util.Arrays;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 20106,
		name = "Array Manipulation",
		url = "https://www.hackerrank.com/challenges/crush",
		category = "Data Structures",
		subCategory = "Arrays"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer length = in.nextInt();
			Integer operations = in.nextInt();

			long[] array = new long[length];
			Arrays.setAll(array, index -> 0);

			for (Integer i = 0; i < operations; ++i)
			{
				Integer a = in.nextInt() - 1;
				Integer b = in.nextInt() - 1;
				Integer k = in.nextInt();

				array[a] = array[a] + k;
				if (b < length - 1)
				{
					array[b + 1] = array[b + 1] - k;
				}
			}

			Long sum = 0L;
			Long max = 0L;

			for (int i = 0; i < length; ++i)
			{
				sum += array[i];
				max = Math.max(max, sum);
			}

			System.out.println(max);
		}
	}
}