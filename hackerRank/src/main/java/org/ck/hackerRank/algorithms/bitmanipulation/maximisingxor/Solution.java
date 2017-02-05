package org.ck.hackerRank.algorithms.bitmanipulation.maximisingxor;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 11002,
		name = "Maximizing XOR",
		url = "https://www.hackerrank.com/challenges/maximizing-xor",
		category = "Algorithms",
		subCategory = "Bit Manipulation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer a = in.nextInt();

			Integer b = in.nextInt();

			Integer max = Integer.MIN_VALUE;
			for (Integer i = a; i <= b; ++i)
			{
				for (Integer j = i; j <= b; ++j)
				{
					Integer xor = i ^ j;

					max = Math.max(xor, max);
				}
			}

			System.out.println(max);
		}
	}
}