package org.ck.hackerRank.algorithms.combinatorics.handshake;

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
				Integer people = in.nextInt();

				System.out.println((people * (people - 1)) / 2);
			}
		}
	}
}