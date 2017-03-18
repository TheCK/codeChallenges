package org.ck.hackerRank.corecs.algorithms.strings.pangrams;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10307,
		name = "Pangrams",
		url = "https://www.hackerrank.com/challenges/pangrams",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String string = in.nextLine();

			boolean isPangram = string.toLowerCase()
					.chars()
					.distinct()
					.filter(number -> number >= 97 && number <= 122)
					.count() == 26;

			System.out.println(isPangram ? "pangram" : "not pangram");
		}
	}
}