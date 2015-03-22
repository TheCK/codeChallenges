package org.ck.projectEuler.solutions.problem179;

import org.ck.projectEuler.lib.MyMath;

public class ConsecutivePositiveDivisors
{

	private static int result = 0;

	public static void main(String[] args)
	{
		for (int i = 2; i < 10000000; ++i)
		{
			if (MyMath.getDivisors(i).size() == MyMath.getDivisors(i + 1).size())
			{
				result++;
			}
		}
		
		printResult();
	}

	private static void printResult()
	{
		System.out.println(result);
	}

}