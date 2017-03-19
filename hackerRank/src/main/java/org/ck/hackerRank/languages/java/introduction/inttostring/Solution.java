package org.ck.hackerRank.languages.java.introduction.inttostring;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40201011,
		name = "Java Int to String",
		url = "https://www.hackerrank.com/challenges/java-int-to-string",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	public static void main(String[] args)
	{
		// given start
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		// given end

		String s = String.valueOf(n);

		// given start
		if (n == Integer.parseInt(s))
		{
			System.out.println("Good job");
		}
		else
		{
			System.out.println("Wrong answer.");
		}
		// given end
	}
}