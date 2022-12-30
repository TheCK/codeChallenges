package org.ck.hackerrank.corecs.algorithms.warmup.solvemefirst;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10101,
		name = "Solve me first",
		url = "https://www.hackerrank.com/challenges/solve-me-first",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	static int solveMeFirst(int a, int b)
	{
		return a + b;
	}

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int a;
			a = in.nextInt();

			int b;
			b = in.nextInt();

			int sum = solveMeFirst(a, b);

			System.out.println(sum);
		}
	}
}