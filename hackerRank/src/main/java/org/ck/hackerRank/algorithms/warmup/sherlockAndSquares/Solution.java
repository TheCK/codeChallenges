package org.ck.hackerRank.algorithms.warmup.sherlockAndSquares;

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
				int start = in.nextInt();
				int end = in.nextInt();
				
				int rootStart = (int) Math.ceil(Math.sqrt(start));
				int rootEnd = (int) Math.sqrt(end);
				
				System.out.println(rootEnd - rootStart + 1);
			}
		}
	}
}