package org.ck.hackerrank.corecs.algorithms.dynamicprogramming.maxsubarray;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10812,
		name = "The Maximum Subarray",
		url = "https://www.hackerrank.com/challenges/maxsubarray",
		category = "Algorithms",
		subCategory = "Dynamic Programming"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cases = in.nextInt();

			for (Integer i = 0; i < cases; ++i)
			{
				Integer numbers = in.nextInt();

				Integer[] array = new Integer[numbers];

				for (Integer j = 0; j < numbers; ++j)
				{
					array[j] = in.nextInt();
				}

				Integer nonContiguousMax = 0;
				Integer biggestNegativeNumber = Integer.MIN_VALUE;

				Integer contiguousMax = 0;
				Integer maxEndingHere = 0;

				for (Integer start = 0; start < numbers; ++start)
				{
					if (array[start] > 0)
					{
						nonContiguousMax += array[start];
					}
					else
					{
						biggestNegativeNumber = Math.max(biggestNegativeNumber, array[start]);
					}

					maxEndingHere += array[start];
					maxEndingHere = Math.max(maxEndingHere, 0);
					contiguousMax = Math.max(maxEndingHere, contiguousMax);
				}

				if (nonContiguousMax == 0)
				{
					nonContiguousMax = biggestNegativeNumber;
				}
				if (contiguousMax == 0)
				{
					contiguousMax = biggestNegativeNumber;
				}

				System.out.println(contiguousMax + " " + nonContiguousMax);
			}
		}
	}
}