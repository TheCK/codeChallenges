package org.ck.hackerRank.algorithms.warmup.theLoveLetterMystery;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = in.nextInt();
			in.nextLine();

			for (int i = 0; i < count; ++i)
			{
				int changes = 0;
				String line = in.nextLine();
				
				for (int position = 0; position < line.length() / 2; ++position)
				{
					char first = line.charAt(position);
					char last = line.charAt(line.length() - 1 - position);
					
					int diff = Math.abs(last - first);
					changes += diff;
				}
				
				System.out.println(changes);
			}
		}
	}
}