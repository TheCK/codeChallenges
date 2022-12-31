package org.ck.hackerrank.corecs.algorithms.implementation.viraladvertising;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10219,
		name = "Viral Advertising",
		url = "https://www.hackerrank.com/challenges/strange-advertising",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int days = in.nextInt();

			int seen = 0;
			int receivedToday = 5;
			for (int i = 0; i < days; ++i)
			{
				int likers = receivedToday / 2;
				seen += likers;

				receivedToday = 3 * likers;
			}

			System.out.println(seen);
		}
	}
}