package org.ck.hackerrank.corecs.algorithms.implementation.taumandbday;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10236,
		name = "Taum and B'day",
		url = "https://www.hackerrank.com/challenges/taum-and-bday",
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
				long blackGifts = in.nextLong();
				long whiteGifts = in.nextLong();

				long blackPrice = in.nextLong();
				long whitePrice = in.nextLong();
				long switchPrice = in.nextLong();

				long price;
				if (blackPrice + switchPrice < whitePrice)
				{
					price = (blackPrice + switchPrice) * whiteGifts + blackPrice * blackGifts;
				}
				else if (whitePrice + switchPrice < blackPrice)
				{
					price = whitePrice * whiteGifts + (whitePrice + switchPrice) * blackGifts;
				}
				else
				{
					price = whitePrice * whiteGifts + blackPrice * blackGifts;
				}

				System.out.println(price);
			}
		}
	}
}