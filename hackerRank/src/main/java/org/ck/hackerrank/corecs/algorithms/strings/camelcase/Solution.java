package org.ck.hackerrank.corecs.algorithms.strings.camelcase;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10302,
		name = "CamelCase",
		url = "https://www.hackerrank.com/challenges/camelcase",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String line = in.nextLine();

			int words = 1;
			for (char character : line.toCharArray())
			{
				if (Character.isUpperCase(character))
				{
					++words;
				}
			}

			System.out.println(words);
		}
	}
}