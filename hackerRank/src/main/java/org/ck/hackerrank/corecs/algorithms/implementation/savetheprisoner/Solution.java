package org.ck.hackerrank.corecs.algorithms.implementation.savetheprisoner;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10220,
		name = "Save the Prisoner!",
		url = "https://www.hackerrank.com/challenges/save-the-prisoner",
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

			for (int i = 0; i < testCases; ++i)
			{
				long prisoner = in.nextLong();
				long sweets = in.nextLong();
				long start = in.nextLong();

				long lastSweet = (sweets % prisoner + start - 1) % prisoner;
				System.out.println(lastSweet != 0 ? lastSweet : prisoner);
			}
		}
	}
}