package org.ck.projectEuler.lib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyMath
{

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
	
	public static boolean isPrime(long num)
	{
		if (num <= 0 ) return false;
		
		boolean isPrime = true;
		long limit = (long) Math.sqrt(num);

		for (long i = 2; i <= limit; i++)
		{
			if (num % i == 0)
			{
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
	
	public static List<Integer> getDigits(int number)
	{
		List<Integer> digits = new ArrayList<>();
		
		int remainingNumber = number;
		while (remainingNumber != 0)
		{
			digits.add(remainingNumber % 10);
			remainingNumber /= 10;
		}
		
		if (digits.size() == 0) digits.add(0);
		
		return digits;
	}
	
	public static Set<String> getUniqueDigits(String number)
	{
		Set<String> digits = new HashSet<>();
		
		for(int i = 0; i < number.length(); ++i)
		{
			digits.add(number.substring(i, i+1));
		}
		
		if (digits.size() == 0) digits.add("0");
		
		return digits;
	}
	
    public static long factorial(int N)
    {
        long multi = 1;
        for (int i = 1; i <= N; i++) {
            multi = multi * i;
        }
        return multi;
    }
    
    public static boolean isNDigit(Set<String> digits)
    {
		for (int n = 1; n <= digits.size(); ++n)
		{
			if (!digits.contains(String.valueOf(n)))
			{
				return false;
			}
		}
		
		return true;
    }
    
    public static Set<Integer> getDivisors(Integer number)
    {
    	Set<Integer> divisors = new HashSet<>();
    	
		int limit = (int) Math.sqrt(number);
		for (int i = 1; i <= limit + 1; i++)
		{
			if (number % i == 0)
			{
				divisors.add(i);
				divisors.add(number / i);
			}
		}

		return divisors;
    }
    
    public static Set<Long> getDivisors(Long number)
    {
    	Set<Long> divisors = new HashSet<>();
    	
		long limit = (long) Math.sqrt(number);
		for (long i = 1; i <= limit + 1; i++)
		{
			if (number % i == 0)
			{
				divisors.add(i);
				divisors.add(number / i);
			}
		}

		return divisors;
    }
    
    public static boolean isPalindrome(String number)
    {
    	StringBuilder builder = new StringBuilder(number);
    	
    	return builder.reverse().toString().equals(number);
    }
    
    public static boolean isPalindrome(int number)
    {
    	return isPalindrome(Integer.toString(number));
    }
}
