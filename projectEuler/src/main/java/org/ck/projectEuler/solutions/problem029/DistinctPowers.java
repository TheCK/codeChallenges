package org.ck.projectEuler.solutions.problem029;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class DistinctPowers
{
	private static Set<BigInteger> powers = new HashSet<>();

	public static void main(String[] args)
	{
		for (int a = 2; a <= 100; ++a)
		{
			BigInteger bigA = BigInteger.valueOf(a);
			
			for (int b = 2; b <= 100; ++b)
			{
				powers.add(bigA.pow(b));
			}
		}

		printResult();
	}

	private static void printResult()
	{
		System.out.println(powers.size());
	}
}
