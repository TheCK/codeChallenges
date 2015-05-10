package org.ck.codeEval.easy.primePalindrome;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 3, name = "Prime Palindrome", description = "Biggest prime palindrome < 1000.", url = "https://www.codeeval.com/open_challenges/3/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args)
	{
		int result = 2;
		
		for (int i = 3; i < 1000; ++i)
		{
			if (isPrime(i))
			{
				if (isPalindrome(i))
				{
					result = i;
				}
			}
		}
		
		System.out.println(result);
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
	

	private static boolean isPalindrome(Integer i)
	{
		String numberString = i.toString();
		
		StringBuilder builder = new StringBuilder(numberString);
		String reverseString = builder.reverse().toString();
		
		return numberString.equals(reverseString);
	}
}
