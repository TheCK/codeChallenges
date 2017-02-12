package org.ck.hackerRank.algorithms.implementation.absolutepermutation;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10244,
		name = "Absolute Permutation",
		url = "https://www.hackerrank.com/challenges/absolute-permutation",
		category = "Algorithms",
		subCategory = "Implementation",
		solved = false
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

				if (k == 0)
				{
					System.out.println(IntStream.range(1, n + 1)
							.boxed()
							.map(String::valueOf)
							.collect(Collectors.joining(" "))
					);
				}
				else if (n % 2 == 0 && n / 2 == k)
				{
					System.out.print(IntStream.range(n / 2 + 1, n + 1)
							.boxed()
							.map(String::valueOf)
							.collect(Collectors.joining(" "))
					);
					System.out.print(" ");
					System.out.println(IntStream.range(1, n / 2 + 1)
							.boxed()
							.map(String::valueOf)
							.collect(Collectors.joining(" "))
					);
				}
				else
				{
					System.out.println("-1");
				}
			}
		}
	}
}