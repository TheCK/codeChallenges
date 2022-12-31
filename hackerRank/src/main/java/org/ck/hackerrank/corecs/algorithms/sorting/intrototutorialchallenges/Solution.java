package org.ck.hackerrank.corecs.algorithms.sorting.intrototutorialchallenges;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10401,
		name = "Intro to Tutorial Challenges",
		url = "https://www.hackerrank.com/challenges/tutorial-intro",
		category = "Algorithms",
		subCategory = "Sorting"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int search = in.nextInt();

			int count = in.nextInt();

			for (int i = 0; i < count; ++i)
			{
				if (in.nextInt() == search)
				{
					System.out.println(i);
					break;
				}
			}
		}
	}
}