package org.ck.hackerRank.corecs.algorithms.implementation.designerpdfviewer;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10215,
		name = "Designer PDF Viewer",
		url = "https://www.hackerrank.com/challenges/designer-pdf-viewer",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	private static int NUMBER_COUNT = 26;

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int[] heights = new int[NUMBER_COUNT];
			for (int i = 0; i < NUMBER_COUNT; ++i)
			{
				heights[i] = in.nextInt();
			}

			String word = in.next("[a-z]+");
			int maximum = 0;
			for (char letter : word.toCharArray())
			{
				if (maximum < heights[letter - 'a'])
				{
					maximum = heights[letter - 'a'];
				}
			}

			System.out.println(maximum * word.length());
		}
	}
}