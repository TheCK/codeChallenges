package org.ck.projecteuler.solutions.problem049;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ck.projecteuler.lib.MyMath;

public class PrimePermutations
{
	public static void main(String[] args)
	{
		List<Integer> primes = getPrimesBelow(10000);

		for (Integer prime1 : primes)
		{
			for (Integer prime2 : primes)
			{
				if (prime2 <= prime1)
					continue;

				Integer diff = prime2 - prime1;
				Integer testPrime = prime2 + diff;

				if (MyMath.isPrime(testPrime))
				{
					Set<String> digits1 = MyMath.getUniqueDigits(prime1.toString());
					Set<String> digits2 = MyMath.getUniqueDigits(prime2.toString());
					Set<String> digits3 = MyMath.getUniqueDigits(testPrime.toString());

					Set<String> all = new HashSet<>();
					all.addAll(digits1);
					all.addAll(digits2);
					all.addAll(digits3);

					if (digits1.size() == digits2.size() && digits2.size() == digits3.size() &&
							digits3.size() == all.size() && prime1.toString().length() == prime2.toString().length() &&
							prime2.toString().length() == testPrime.toString().length())
					{
						if (!prime1.equals(1487))
						{
							System.out.println(prime1 + "" + prime2 + "" + testPrime);
						}
					}
				}
			}
		}
	}

	private static List<Integer> getPrimesBelow(int max)
	{
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i < max; ++i)
		{
			if (MyMath.isPrime(i))
			{
				primes.add(i);
			}
		}

		return primes;
	}
}