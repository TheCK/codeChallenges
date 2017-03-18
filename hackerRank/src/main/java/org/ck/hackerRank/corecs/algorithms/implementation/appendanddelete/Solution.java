package org.ck.hackerRank.corecs.algorithms.implementation.appendanddelete;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10226,
		name = "Append and Delete",
		url = "https://www.hackerrank.com/challenges/append-and-delete",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String firstString = in.nextLine();
			String secondString = in.nextLine();
			Integer steps = in.nextInt();

			boolean canConvert = checkStrings(firstString, secondString, steps);

			System.out.println(canConvert ? "Yes" : "No");
		}
	}

	private static boolean checkStrings(String firstString, String secondString, Integer steps)
	{
		int similarites = 0;
		for (int i = 0; i < Math.min(firstString.length(), secondString.length()); ++i)
		{
			if (firstString.charAt(i) == secondString.charAt(i))
			{
				++similarites;
			}
			else
			{
				break;
			}
		}
		System.err.println(similarites);
		int remainder = steps - ((firstString.length() - similarites) + (secondString.length() - similarites));
		System.err.println(remainder);

		return ((remainder >= 0) && (remainder % 2 == 0)) || ((firstString.length() + secondString.length()) <= steps);
	}
}