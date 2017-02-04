package org.ck.hackerRank.algorithms.decommissioned.alternatingCharacters;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer cases = Integer.valueOf(in.nextLine());

			for (Integer i = 0; i < cases; ++i)
			{
				StringBuilder builder = new StringBuilder(in.nextLine());
				Integer deletions = 0;
				
				Integer counter = 0;
				Character lastChar = null;
				while(counter < builder.length())
				{
					Character currentChar = builder.charAt(counter);
					
					if(currentChar.equals(lastChar))
					{
						builder.deleteCharAt(counter);
						++deletions;
					}
					else
					{
						lastChar = currentChar;
						++counter;
					}
				}

				System.out.println(deletions);
			}
		}
	}
}