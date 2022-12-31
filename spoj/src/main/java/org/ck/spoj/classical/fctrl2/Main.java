package org.ck.spoj.classical.fctrl2;

import org.ck.codechallengelib.annotation.Solution;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

@Solution(
		id = 1000024,
		name = "FCTRL2 - Small factorials",
		url = "http://www.spoj.com/problems/FCTRL2/",
		category = "classical"
)
public class Main
{
	public static void main(String[] args) throws IOException
	{
		try (Scanner in = new Scanner(System.in))
		{
			int numberOfTestCases = in.nextInt();

			for (int i = 0; i < numberOfTestCases; ++i)
			{
				BigInteger number = in.nextBigInteger();

				System.out.println(factorial(number));
			}

		}
	}

	private static BigInteger factorial(BigInteger number)
	{
		if (number.equals(BigInteger.ONE))
		{
			return BigInteger.ONE;
		}

		return number.multiply(factorial(number.subtract(BigInteger.ONE)));
	}
}