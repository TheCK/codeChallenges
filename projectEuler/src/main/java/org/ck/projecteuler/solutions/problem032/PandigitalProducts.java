package org.ck.projecteuler.solutions.problem032;

import java.util.HashSet;
import java.util.Set;

public class PandigitalProducts
{
	public static void main(String[] args)
	{
		Set<Integer> multiples = new HashSet<>();

		for (int i = 1; i < 50; ++i)
		{
			String iString = String.valueOf(i);
			
			for (int j = 1; j < 2000; ++j)
			{
				int mul = i * j;

				if (!multiples.contains(mul) && isPandigital(String.valueOf(mul) + iString + String.valueOf(j)))
				{
					multiples.add(mul);
				}
			}
		}
		
		long sum = multiples.parallelStream().mapToInt(Integer::intValue).sum();

		System.out.println(sum);
	}

	private static boolean isPandigital(String string)
	{
		if (string.length() != 9)
		{
			return false;
		}
		if (!string.contains("1") 
				|| !string.contains("2") 
				|| !string.contains("3")
				|| !string.contains("4") 
				|| !string.contains("5")
				|| !string.contains("6") 
				|| !string.contains("7")
				|| !string.contains("8") 
				|| !string.contains("9"))
		{
			return false;
		}

		return true;
	}
}
