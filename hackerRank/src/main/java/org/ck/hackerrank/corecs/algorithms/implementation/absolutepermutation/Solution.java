package org.ck.hackerrank.corecs.algorithms.implementation.absolutepermutation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(
		id = 10254,
		name = "Absolute Permutation",
		url = "https://www.hackerrank.com/challenges/absolute-permutation",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int testCases = in.nextInt();

			for (int testCase = 0; testCase < testCases; ++testCase)
			{
				int n = in.nextInt();
				int k = in.nextInt();

				int[] permutation = new int[n];
				Arrays.fill(permutation, 0);
				for (int i = 1; i <= n; ++i)
				{
					for (int candidate : Arrays.asList(i - k, i + k))
					{
						if (candidate > 0 && candidate <= n && permutation[candidate - 1] == 0)
						{
							permutation[candidate - 1] = i;
							break;
						}
					}
				}

				int[] containedNumbers = Arrays.copyOf(permutation, permutation.length);
				Arrays.sort(containedNumbers);
				if (Arrays.binarySearch(containedNumbers, 0) < 0)
				{
					System.out.println(
							Arrays.stream(permutation)
									.boxed()
									.map(number -> number.toString())
									.collect(Collectors.joining(" "))
					);
				}
				else
				{
					System.out.println(-1);
				}
			}
		}
	}
}