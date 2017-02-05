package org.ck.hackerRank.mathematics.fundamentals.halloweenparty;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30118,
		name = "Halloween party",
		url = "https://www.hackerrank.com/challenges/halloween-party",
		category = "Mathematics",
		subCategory = " Fundamentals"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int cases = in.nextInt();

			for (int i = 0; i < cases; ++i)
			{
				int cuts = in.nextInt();

				long verticalCuts = cuts / 2;
				long horitontalCuts = cuts - verticalCuts;

				System.out.println(verticalCuts * horitontalCuts);
			}
		}
	}
}