package org.ck.projecteuler.solutions.problem050;

import java.util.ArrayList;
import java.util.List;

import org.ck.projecteuler.lib.MyMath;

public class ConsecutivePrimeSum
{
	private static int MAX = 1000000;

	private static int resultPrime = 0;
	private static int resultLength = 0;

	public static void main(String[] args)
	{
		List<Integer> primes = getPrimesBelow(MAX);
		
		for (int i = 0; i < primes.size() - 1; ++i)
		{
			Integer sum = primes.get(i);
			
			for(int j = i + 1; j < primes.size(); ++j)
			{
				Integer addPrime = primes.get(j);
				
				sum += addPrime;
				
				if (sum > MAX)
					break;
				
				if (MyMath.isPrime(sum))
				{
					Integer length = j - i + 1;
					
					if (length > resultLength)
					{
						resultLength = length;
						resultPrime = sum;
					}
				}
			}
		}
		
		printResult();
	}

	private static List<Integer> getPrimesBelow(int max)
	{
		List<Integer> primes = new ArrayList<>();
		
		for(int i = 2; i < max; ++i)
		{
			if (MyMath.isPrime(i))
			{
				primes.add(i);
			}
		}
		
		return primes;
	}

	private static void printResult()
	{
		System.out.println(resultPrime);
	}

}