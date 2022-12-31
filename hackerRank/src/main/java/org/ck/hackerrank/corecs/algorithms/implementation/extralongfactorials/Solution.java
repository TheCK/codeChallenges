package org.ck.hackerrank.corecs.algorithms.implementation.extralongfactorials;

import java.math.BigInteger;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10225,
		name = "Extra Long Factorials",
		url = "https://www.hackerrank.com/challenges/extra-long-factorials",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Long number = in.nextLong();

			BigInteger result = BigInteger.valueOf(number);

			while (number != 1)
			{
				--number;

				result = result.multiply(BigInteger.valueOf(number));
			}

			System.out.println(result);
		}
	}
}