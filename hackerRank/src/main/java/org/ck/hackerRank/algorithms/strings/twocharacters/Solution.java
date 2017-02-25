package org.ck.hackerRank.algorithms.strings.twocharacters;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10403,
		name = "Two Characters",
		url = "https://www.hackerrank.com/challenges/two-characters",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			in.nextInt();
			String string = in.next();

			List<Character> collect = string.chars()
					.distinct()
					.mapToObj(ascii -> new Character((char) ascii))
					.collect(Collectors.toList());

			String longestT = "";

			for (char remainder1 : collect)
			{
				for (char remainder2 : collect)
				{
					if (remainder1 == remainder2)
					{
						continue;
					}

					String candidate = string;

					for (char toBeRemoved : collect)
					{
						if (toBeRemoved == remainder1 || toBeRemoved == remainder2)
						{
							continue;
						}

						candidate = candidate.replaceAll(String.valueOf(toBeRemoved), "");
					}

					if (isT(candidate) && candidate.length() > longestT.length())
					{
						longestT = candidate;
					}
				}
			}

			System.out.println(longestT.length());
		}
	}

	private static boolean isT(String candidate)
	{
		char previous = '\0';

		for (char character : candidate.toCharArray())
		{
			if (character == previous)
			{
				return false;
			}

			previous = character;
		}

		return true;
	}
}