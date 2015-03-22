package org.ck.projectEuler.solutions.problem074;

import java.util.HashSet;
import java.util.Set;

public class DigitFactorialChains
{

	private static int resultLine = 0;

	public static void main(String[] args)
	{
		for (int i = 1; i < 1000000; ++i)
		{
			Set<Integer> chain = new HashSet<>();
			
			Integer current = i;
			
			while (true)
			{	
				if (chain.contains(current))
				{	
					if (chain.size() == 60)
					{
						resultLine++;
					}
					
					break;
				}
				
				chain.add(current);
				
				current = calc(current);
			}
		}

		printResult();
	}

	private static Integer calc(Integer number)
	{
		String numberString = number.toString();
		Integer sum = 0;
		
		for (int i = 0; i < numberString.length(); ++i)
		{
			sum += factorial(Integer.parseInt(numberString.substring(i, i + 1)));
		}
		
		return sum;
	}
	
    public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

	private static void printResult()
	{
		System.out.println(resultLine);
	}
}