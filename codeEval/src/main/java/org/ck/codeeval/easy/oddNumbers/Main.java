package org.ck.codeeval.easy.oddNumbers;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 25, name = "Odd Numbers", description = "Print the odd numbers from 1 to 99.", url = "https://www.codeeval.com/open_challenges/25/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args)
	{
		for (int i = 1; i < 100; ++i)
		{
			if (i % 2 != 0)
			{
				System.out.println(i);
			}
		}
	}
}
