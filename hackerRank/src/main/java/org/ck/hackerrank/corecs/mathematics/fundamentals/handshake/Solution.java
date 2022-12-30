package org.ck.hackerrank.corecs.mathematics.fundamentals.handshake;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 30103,
		name = "Handshake",
		url = "https://www.hackerrank.com/challenges/handshake",
		category = "Mathematics",
		subCategory = "Fundamentals"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cases = in.nextInt();

			for (Integer i = 0; i < cases; ++i)
			{
				Integer people = in.nextInt();

				System.out.println((people * (people - 1)) / 2);
			}
		}
	}
}