package org.ck.hackerRank.corecs.algorithms.warmup.staircase;

import java.util.Collections;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10107,
		name = "Staircase",
		url = "https://www.hackerrank.com/challenges/staircase",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = in.nextInt();

			for (int i = 1; i <= count; ++i)
			{
				System.out.println(String.format(String.format("%%%ds", count), String.join("", Collections.nCopies(i, "#"))));
			}
		}
	}
}