package org.ck.codeEval.hard.palindromicRanges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 47, name = "Palindromic Ranges", description = "Find out a range of palindromic numbers", url = "https://www.codeeval.com/open_challenges/47/", category = "Hard challenges")
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
				String[] range = line.split(" ");
				
				int start = Integer.parseInt(range[0]);
				int end = Integer.parseInt(range[1]);

				int ranges = 0;
				
				for (int i = start; i <= end; ++i)
				{
					for (int j = i; j <= end; ++j)
					{
						int count = 0;
						
						for (int k = i; k<=j; ++k)
						{
							if (isPalindromic(k))
							{
								++count;
							}
						}
						
						if (count % 2 == 0)
						{
							++ranges;
						}
					}
				}
				
				System.out.println(ranges);
			}
		}
	}

	private static boolean isPalindromic(int k)
	{
		String number = String.valueOf(k);
		
		StringBuilder builder = new StringBuilder(number);
		return builder.reverse().toString().equals(number);
	}
}