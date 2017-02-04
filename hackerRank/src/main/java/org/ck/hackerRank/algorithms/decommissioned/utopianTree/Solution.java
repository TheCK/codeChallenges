package org.ck.hackerRank.algorithms.decommissioned.utopianTree;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(id = 10104, name = "Utopian Tree", url = "https://www.hackerrank.com/challenges/utopian-tree", category = "Algorithms", subCategory = "Warmup")
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cases = in.nextInt();

			for (Integer i = 0; i < cases; ++i)
			{
				Integer height = 1;

				Integer cycles = in.nextInt();

				for (Integer j = 0; j < cycles; ++j)
				{
					if (j % 2 == 0)
					{
						height *= 2;
					}
					else
					{
						height += 1;
					}
				}
				
				System.out.println(height);
			}
		}
	}
}