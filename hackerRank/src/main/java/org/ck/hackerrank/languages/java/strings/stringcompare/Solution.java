package org.ck.hackerrank.languages.java.strings.stringcompare;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40202003,
		name = "Java String Compare",
		url = "https://www.hackerrank.com/challenges/java-string-compare",
		category = "Java",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String string = in.nextLine();
			Integer length = in.nextInt();

			String smallest = string.substring(0, length);
			String biggest = string.substring(0, length);

			for (int i = 0; i < string.length() - length + 1; ++i)
			{
				String candidate = string.substring(i, i + length);

				if (smallest.compareTo(candidate) > 0)
				{
					smallest = candidate;
				}

				if (biggest.compareTo(candidate) < 0)
				{
					biggest = candidate;
				}
			}

			System.out.println(smallest);
			System.out.println(biggest);
		}
	}
}