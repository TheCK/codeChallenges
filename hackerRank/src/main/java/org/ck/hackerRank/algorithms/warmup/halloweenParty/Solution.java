package org.ck.hackerRank.algorithms.warmup.halloweenParty;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int cases = in.nextInt();
			
			for (int i = 0; i < cases; ++i)
			{
				int cuts = in.nextInt();

				long verticalCuts = cuts / 2;
				long horitontalCuts = cuts - verticalCuts;
				
				System.out.println(verticalCuts * horitontalCuts);
			}
		}
	}
}