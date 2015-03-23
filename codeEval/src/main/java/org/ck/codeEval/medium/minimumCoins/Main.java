package org.ck.codeEval.medium.minimumCoins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 74, name = "Minimum Coins", description = "Find the minimum number of coins to arrive at a total.", url = "https://www.codeeval.com/open_challenges/74/", category = "Moderate callenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();

				Integer amount = Integer.valueOf(line);
				
				Integer sum = 0;
				while (amount != 0)
				{
					if (amount >= 5)
					{
						amount -= 5;
						sum++;
					}
					else if (amount >= 3)
					{
						amount -= 3;
						sum++;
					}
					else if (amount >= 1)
					{
						amount -= 1;
						sum++;
					}
				}
				System.out.println(sum);
			}
		}
	}
}