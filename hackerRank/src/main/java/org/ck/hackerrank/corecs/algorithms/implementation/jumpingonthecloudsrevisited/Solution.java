package org.ck.hackerrank.corecs.algorithms.implementation.jumpingonthecloudsrevisited;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10223,
		name = "Jumping on the Clouds: Revisited",
		url = "https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cloudAmount = in.nextInt();
			Integer distance = in.nextInt();

			int[] clouds = new int[cloudAmount];
			for (int i = 0; i < cloudAmount; ++i)
			{
				clouds[i] = in.nextInt();
			}

			int position = 0;
			int energy = 100;
			do
			{
				position = (position + distance) % cloudAmount;
				--energy;

				if (clouds[position] == 1)
				{
					energy -= 2;
				}
			}
			while (position != 0 && energy > 0);

			System.out.println(energy);
		}
	}
}