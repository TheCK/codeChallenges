package org.ck.hackerrank.corecs.algorithms.implementation.betweentwosets;

import java.util.*;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10204,
		name = "Between Two Sets",
		url = "https://www.hackerrank.com/challenges/between-two-sets",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	private static int MAX = 101;
	private static List<Integer> cache = new ArrayList<>();

	public static void main(String[] args)
	{
		initPrimes();

		try (Scanner in = new Scanner(System.in))
		{
			int m = in.nextInt();
			int n = in.nextInt();

			int[] firstArray = new int[m];
			for (int i = 0; i < m; ++i)
			{
				firstArray[i] = in.nextInt();
			}

			int[] secondArray = new int[n];
			for (int i = 0; i < n; ++i)
			{
				secondArray[i] = in.nextInt();
			}

			int lcm = getLCM(firstArray);
			int kandidate = lcm;

			int betweens = 0;
			while (kandidate < MAX)
			{
				boolean isDivisible = true;

				for (int i = 0; i < n; ++i)
				{
					if (secondArray[i] % kandidate != 0)
					{
						isDivisible = false;
						break;
					}
				}

				if (isDivisible)
				{
					++betweens;
				}

				kandidate += lcm;
			}

			System.out.println(betweens);
		}
	}

	private static int getLCM(int[] array)
	{
		Map<Integer, Integer> primeFactors = new HashMap<>();

		for (int number : array)
		{
			for (int prime : cache)
			{
				int remainder = number;
				int factor = 0;

				while (remainder % prime == 0)
				{
					remainder /= prime;
					++factor;
				}

				if (factor > 0 && (!primeFactors.containsKey(prime) || primeFactors.get(prime) < factor))
				{
					primeFactors.put(prime, factor);
				}
			}
		}

		int lcm = 1;
		for (int prime : primeFactors.keySet())
		{
			lcm *= prime * primeFactors.get(prime);
		}

		return lcm;
	}

	private static void initPrimes()
	{
		for (int i = 2; i < MAX; ++i)
		{
			if (isPrime(i))
			{
				cache.add(i);
			}
		}
	}

	private static boolean isPrime(int candidate)
	{
		boolean isPrime = true;

		for (int i = 2; i <= Math.sqrt(candidate); ++i)
		{
			if (candidate % i == 0)
			{
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}