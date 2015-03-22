package org.ck.hackerRank.algorithms.combinatorics.minimumDraws;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cases = in.nextInt();

			for (Integer i = 0; i < cases; ++i)
			{
				Integer numberofSocks = in.nextInt();

				System.out.println(numberofSocks + 1);
			}
		}
	}
}