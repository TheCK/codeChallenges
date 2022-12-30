package org.ck.hackerrank.corecs.algorithms.bitmanipulation.flippingbits;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 11006,
		name = "Flipping bits",
		url = "https://www.hackerrank.com/challenges/flipping-bits",
		category = "Algorithms",
		subCategory = "Bit Manipulation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer max = in.nextInt();

			for (Integer i = 1; i <= max; ++i)
			{
				Integer number = (int) in.nextLong();

				number = ~number;

				System.out.println(Integer.toUnsignedString(number));
			}
		}
	}
}