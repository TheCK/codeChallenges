package org.ck.projecteuler.solutions.problem030;

import org.ck.projecteuler.lib.MyMath;

public class DigitFifthPowers
{
	private static Integer numberSum = 0;

	public static void main(String[] args)
	{
		for (int i = 10; i <= 200000; ++i)
		{
			Integer sum = 0;

			for (Integer digit : MyMath.getDigits(i))
			{
				sum += (int) Math.pow(digit, 5);
			}

			if (sum == i)
			{
				numberSum += i;
			}
		}

		printResult();
	}

	private static void printResult()
	{
		System.out.println(numberSum);
	}

}
