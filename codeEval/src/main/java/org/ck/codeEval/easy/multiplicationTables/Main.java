package org.ck.codeEval.easy.multiplicationTables;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 23, name = "Multiplication Tables", description = "Print out the grade school multiplication table upto 12*12", url = "https://www.codeeval.com/open_challenges/23/", category = "Easy callenges")
public class Main
{
	public static void main(String[] args)
	{
		for (int i = 1; i < 13; ++i)
		{
			StringBuilder line = new StringBuilder();
			
			for (int j = 1; j < 13; ++j)
			{
				line.append(String.format("%4d", i*j));
			}
			
			System.out.println(line);
		}
	}
}
