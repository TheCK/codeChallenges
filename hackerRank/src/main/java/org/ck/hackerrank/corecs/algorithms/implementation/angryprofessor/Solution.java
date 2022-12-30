package org.ck.hackerrank.corecs.algorithms.implementation.angryprofessor;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10217,
		name = "Angry Professor",
		url = "https://www.hackerrank.com/challenges/angry-professor",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int testCases = in.nextInt();

			for (int i = 0; i < testCases; ++i)
			{
				int students = in.nextInt();
				int threshold = in.nextInt();

				int studentsOnTime = 0;
				for (int j = 0; j < students; ++j)
				{
					if (in.nextInt() <= 0)
					{
						++studentsOnTime;
					}
				}

				System.out.println(studentsOnTime < threshold ? "YES" : "NO");
			}
		}
	}
}