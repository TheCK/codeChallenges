package org.ck.hackerRank.corecs.algorithms.strings.alternatingcharacters;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10312,
		name = "Alternating Characters",
		url = "https://www.hackerrank.com/challenges/alternating-characters",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cases = Integer.valueOf(in.nextLine());

			for (Integer i = 0; i < cases; ++i)
			{
				StringBuilder builder = new StringBuilder(in.nextLine());
				Integer deletions = 0;

				Integer counter = 0;
				Character lastChar = null;
				while (counter < builder.length())
				{
					Character currentChar = builder.charAt(counter);

					if (currentChar.equals(lastChar))
					{
						builder.deleteCharAt(counter);
						++deletions;
					}
					else
					{
						lastChar = currentChar;
						++counter;
					}
				}

				System.out.println(deletions);
			}
		}
	}
}