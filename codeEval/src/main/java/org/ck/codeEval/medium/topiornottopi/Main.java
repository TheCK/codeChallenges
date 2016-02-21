package org.ck.codeEval.medium.topiornottopi;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

@Solution(id = 228, name = "To PI or not to PI", description = "Print a PI number.", url = "https://www.codeeval.com/open_challenges/228/", category = "Moderate challenges")
public class Main
{
	private static BigDecimal pi;

	public static void main(String[] args) throws Exception
	{
		initPI();

		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				int position = Integer.parseInt(line);

				BigDecimal temp = pi.movePointRight(position - 1);
				System.out.println(temp.toBigInteger().mod(BigInteger.TEN).intValue());
			}
		}
	}

	private static void initPI()
	{
		MathContext context = new MathContext(5000, RoundingMode.HALF_UP);

		BigDecimal start = new BigDecimal(Math.pow(640320, 3d / 2d), context);
		start = new BigDecimal(12, context).divide(start, context);

		BigDecimal sum = BigDecimal.ZERO;
		for (int i = 0; i < 1000; ++i)
		{
			BigInteger numerator1 = BigInteger.valueOf(6 * i);
			numerator1 = factorial(numerator1);

			BigDecimal numerator2 = new BigDecimal(545140134, context);
			numerator2 = numerator2.multiply(new BigDecimal(i, context), context);
			numerator2 = numerator2.add(new BigDecimal(13591409, context), context);

			BigDecimal term = numerator2.multiply(new BigDecimal(numerator1, context), context);

			BigInteger denominator1 = BigInteger.valueOf(3 * i);
			denominator1 = factorial(denominator1);

			BigInteger denominator2 = BigInteger.valueOf(i);
			denominator2 = factorial(denominator2);
			denominator2 = denominator2.pow(3);

			BigInteger denominator3 = BigInteger.valueOf(-6403210);
			denominator3 = denominator3.pow(3 * i);

			term = term.divide(new BigDecimal(denominator1), context);
			term = term.divide(new BigDecimal(denominator2), context);
			term = term.divide(new BigDecimal(denominator3), context);

			sum = sum.add(term, context);
		}

		sum = sum.multiply(start, context);
		pi = BigDecimal.ONE.divide(sum, context);
	}

	public static BigInteger factorial(BigInteger number)
	{
		BigInteger result = BigInteger.ONE;

		while (!number.equals(BigInteger.ZERO))
		{
			result = result.multiply(number);

			number = number.subtract(BigInteger.ONE);
		}

		return result;
	}
}