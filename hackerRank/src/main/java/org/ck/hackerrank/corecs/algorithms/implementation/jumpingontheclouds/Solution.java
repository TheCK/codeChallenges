package org.ck.hackerrank.corecs.algorithms.implementation.jumpingontheclouds;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10232,
		name = "Jumping on the Clouds",
		url = "https://www.hackerrank.com/challenges/jumping-on-the-clouds",
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

			int[] clouds = new int[n];
			for (int i = 0; i < n; ++i)
			{
				clouds[i] = in.nextInt();
			}

			int position = 0;
			int steps = 0;
			while (position != n - 1)
			{
				if (position + 3 <= n && clouds[position + 2] != 1)
				{
					position += 2;
				}
				else
				{
					++position;
				}

				++steps;
			}

			System.out.println(steps);
		}
	}
}