package org.ck.hackerRank.corecs.algorithms.warmup.simplearraysum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10102,
		name = "Simple Array Sum",
		url = "https://www.hackerrank.com/challenges/simple-array-sum",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count;
			count = in.nextInt();

			List<Integer> array = new ArrayList<>();

			for (int i = 0; i < count; ++i)
			{
				array.add(in.nextInt());
			}

			System.out.println(
					array.stream()
							.mapToInt(Integer::intValue)
							.sum()
			);
		}
	}
}