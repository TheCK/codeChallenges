package org.ck.hackerRank.algorithms.warmup.flippingBits;

import java.util.Scanner;

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