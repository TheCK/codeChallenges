package org.ck.hackerrank.corecs.algorithms.implementation.bonappetit;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10208,
		name = "Bon Appétit",
		url = "https://www.hackerrank.com/challenges/bon-appetit",
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

			int[] items = new int[n];
			for (int i = 0; i < n; ++i)
			{
				items[i] = in.nextInt();
			}

			int charge = in.nextInt();

			int fairSum = 0;
			for (int i = 0; i < n; ++i)
			{
				if (i != k)
				{
					fairSum += items[i];
				}
			}
			fairSum /= 2;

			System.out.println(fairSum == charge ? "Bon Appetit" : charge - fairSum);
		}
	}
}