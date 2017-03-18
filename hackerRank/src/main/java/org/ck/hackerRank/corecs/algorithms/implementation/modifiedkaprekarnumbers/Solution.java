package org.ck.hackerRank.corecs.algorithms.implementation.modifiedkaprekarnumbers;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10240,
		name = "Modified Kaprekar Numbers",
		url = "https://www.hackerrank.com/challenges/kaprekar-numbers",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int min = in.nextInt();
			int max = in.nextInt();

			String result = IntStream.range(min, max + 1)
					.filter(number -> isKaprekar(number))
					.mapToObj(number -> String.valueOf(number))
					.collect(Collectors.joining(" "));

			System.out.println(result.length() > 0 ? result : "INVALID RANGE");
		}
	}

	private static boolean isKaprekar(long number)
	{
		int numberLength = String.valueOf(number).length();

		String square = String.valueOf(number * number);
		int divider = square.length() - numberLength;
		String firstPart = square.substring(0, divider);
		String lastPart = square.substring(divider);

		long leftPart;
		if (firstPart.length() > 0)
		{
			leftPart = Long.parseLong(firstPart);
			if (leftPart == 0)
			{
				return false;
			}
		}
		else
		{
			leftPart = 0;
		}

		return leftPart + Long.parseLong(lastPart) == number;
	}
}