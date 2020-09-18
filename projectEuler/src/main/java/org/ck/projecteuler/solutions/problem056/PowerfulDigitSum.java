package org.ck.projecteuler.solutions.problem056;

import java.math.BigInteger;

public class PowerfulDigitSum
{

	private static int resultSum = 1;
	private static BigInteger limit = BigInteger.valueOf(100L);

	public static void main(String[] args)
	{
		for (BigInteger i = BigInteger.ONE; i.compareTo(limit) < 0; i = i.add(BigInteger.ONE))
		{
			for (int j = 1; j <= 100; ++j)
			{
				BigInteger pow = i.pow(j);
				
				int sum = digitSum(pow);
				
				if (sum > resultSum)
				{
					resultSum = sum;
				}
			}
		}

		printResult();
	}
	
	private static int digitSum(BigInteger number) {
	    char[] k = number.toString().toCharArray();
	    int ds = 0;
	    for(int i = 0; i < k.length; i++){
	        ds += Integer.parseInt(String.valueOf(k[i]));
	    }
	    return ds;
	}

	private static void printResult()
	{
		System.out.println(resultSum);
	}

}