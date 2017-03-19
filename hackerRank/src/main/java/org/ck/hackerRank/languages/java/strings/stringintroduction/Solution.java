package org.ck.hackerRank.languages.java.strings.stringintroduction;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40202001,
		name = "Java Strings Introduction",
		url = "https://www.hackerrank.com/challenges/java-strings-introduction",
		category = "Java",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String one = in.nextLine();
			String two = in.nextLine();

			System.out.println(one.length() + two.length());
			System.out.println(one.compareTo(two) > 0 ? "Yes" : "No");
			System.out.println(one.substring(0, 1).toUpperCase() + one.substring(1) + " "
					+ two.substring(0, 1).toUpperCase() + two.substring(1));
		}
	}
}