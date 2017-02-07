package org.ck.hackerRank.algorithms.implementation.libraryfine;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10219,
		name = "Library Fine",
		url = "https://www.hackerrank.com/challenges/library-fine",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int returnedDay = in.nextInt();
			int returnedMonth = in.nextInt();
			int returnedYear = in.nextInt();

			int expectedDay = in.nextInt();
			int expectedMonth = in.nextInt();
			int expectedYear = in.nextInt();

			int fine = 0;
			if (returnedYear > expectedYear)
			{
				fine = 10000 * (returnedYear - expectedYear);
			}

			if (returnedYear == expectedYear
					&& returnedMonth > expectedMonth)
			{
				fine = 500 * (returnedMonth - expectedMonth);
			}
			if (returnedYear == expectedYear
					&& returnedMonth == expectedMonth
					&& returnedDay > expectedDay)
			{
				fine = 15 * (returnedDay - expectedDay);
			}

			System.out.println(fine);
		}
	}
}