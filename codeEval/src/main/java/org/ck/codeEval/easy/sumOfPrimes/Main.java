package org.ck.codeEval.easy.sumOfPrimes;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 4, name = "Sum of Primes", description = "Sum of first 1000 primes.", url = "https://www.codeeval.com/open_challenges/4/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args)
	{
		int sum = 2;
		int primeCount = 1;
		
		for (int i = 3; primeCount < 1000; ++i)
		{
			if (isPrime(i))
			{
				sum += i;
				++primeCount;
			}
		}
		
		System.out.println(sum);
	}

	public static boolean isPrime(int num)
	{
		if (num <= 0 ) return false;
		
		boolean isPrime = true;
		int limit = (int) Math.sqrt(num);

		for (int i = 2; i <= limit; i++)
		{
			if (num % i == 0)
			{
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}
