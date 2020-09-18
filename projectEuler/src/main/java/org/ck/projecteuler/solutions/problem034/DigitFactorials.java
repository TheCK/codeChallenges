package org.ck.projecteuler.solutions.problem034;

import org.ck.projecteuler.lib.MyMath;

public class DigitFactorials
{
	private static int numberSum = 0;

	public static void main(String[] args)
	{
		for (int i = 10; i <= 41000; ++i)
		{
			int sum = 0;
			
			for(Integer digit : MyMath.getDigits(i))
			{
				sum += (int) MyMath.factorial(digit);
			}
		
			if(sum == i)
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