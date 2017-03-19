package org.ck.hackerRank.languages.java.introduction.stdinandstdoutii;

import java.util.Locale;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40201003,
		name = "Java Stdin and Stdout II",
		url = "https://www.hackerrank.com/challenges/java-stdin-stdout",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	public static final int NUMBER = 3;

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			in.useLocale(Locale.US);

			int integerValue = in.nextInt();
			double doubleValue = in.nextDouble();

			in.nextLine();
			String stringValue = in.nextLine();

			System.out.println("String: " + stringValue);
			System.out.println("Double: " + doubleValue);
			System.out.println("Int: " + integerValue);
		}
	}
}