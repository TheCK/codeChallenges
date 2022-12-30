package org.ck.hackerrank.corecs.algorithms.implementation.kangaroo;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10203,
		name = "Kangaroo",
		url = "https://www.hackerrank.com/challenges/kangaroo",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int x1 = in.nextInt();
			int v1 = in.nextInt();

			int x2 = in.nextInt();
			int v2 = in.nextInt();

			boolean meeting = false;
			if (v1 > v2)
			{
				while (x1 < x2)
				{
					x1 += v1;
					x2 += v2;

					if (x1 == x2)
					{
						meeting = true;
					}
				}
			}

			System.out.println(meeting ? "YES" : "NO");
		}
	}
}