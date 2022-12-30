package org.ck.hackerrank.languages.java.introduction.currencyformatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40201013,
		name = "Java Currency Formatter",
		url = "https://www.hackerrank.com/challenges/java-currency-formatter",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			in.useLocale(Locale.US);
			double value = in.nextDouble();

			NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
			NumberFormat indianFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
			NumberFormat chineseFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
			NumberFormat frenchFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

			System.out.println("US: " + usFormat.format(value));
			System.out.println("India: " + indianFormat.format(value));
			System.out.println("China: " + chineseFormat.format(value));
			System.out.println("France: " + frenchFormat.format(value));
		}
	}
}