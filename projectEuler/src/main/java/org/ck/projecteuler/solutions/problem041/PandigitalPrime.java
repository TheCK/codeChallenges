package org.ck.projecteuler.solutions.problem041;

import java.util.Set;
import java.util.stream.IntStream;

import org.ck.projecteuler.lib.MyMath;

public class PandigitalPrime
{
	private static int result = 1;

	public static void main(String[] args)
	{
		result = IntStream.rangeClosed(0, 7654321)
				.parallel()
				.filter(PandigitalPrime::isNDigit)
				.filter(MyMath::isPrime)
				.max().orElse(0);

		printResult();
	}

	private static boolean isNDigit(int i)
	{
		String iString = String.valueOf(i);
		Set<String> digits = MyMath.getUniqueDigits(iString);

		return iString.length() == digits.size() && !digits.contains("0") && MyMath.isNDigit(digits);
	}

	private static void printResult()
	{
		System.out.println(result);
	}
}