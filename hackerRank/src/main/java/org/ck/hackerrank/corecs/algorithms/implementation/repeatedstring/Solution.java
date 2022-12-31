package org.ck.hackerrank.corecs.algorithms.implementation.repeatedstring;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10231,
		name = "Repeated String",
		url = "https://www.hackerrank.com/challenges/repeated-string",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String text = in.nextLine();
			long length = in.nextLong();

			long repetitions = length / text.length();
			long remainder = length % text.length();

			long aInText = 0;
			long aInRemainder = 0;
			for (int i = 0; i < text.length(); ++i)
			{
				char character = text.charAt(i);

				if (character == 'a')
				{
					++aInText;

					if (i < remainder)
					{
						++aInRemainder;
					}
				}
			}

			System.out.println(repetitions * aInText + aInRemainder);
		}
	}
}