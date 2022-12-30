package org.ck.hackerrank.corecs.algorithms.implementation.lisasworkbook;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10246,
		name = "Lisa's Workbook",
		url = "https://www.hackerrank.com/challenges/lisa-workbook",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int chapters = in.nextInt();
			int problemsPerPage = in.nextInt();

			int specialProblems = 0;
			int page = 1;
			for (int i = 0; i < chapters; ++i)
			{
				int problems = in.nextInt();
				int remainingProblems = problems;

				while (remainingProblems > 0)
				{
					for (int j = 1; j <= problemsPerPage; ++j)
					{
						if (page == problems - remainingProblems + j && problems - remainingProblems + j <= problems)
						{
							++specialProblems;
						}
					}

					remainingProblems -= problemsPerPage;
					++page;
				}
			}

			System.out.println(specialProblems);
		}
	}
}