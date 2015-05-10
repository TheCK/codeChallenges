package org.ck.codeEval.easy.lettercasePercentageRatio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 147, name = "Lettercase Percentage Ratio", description = "Find the percentage ratio.", url = "https://www.codeeval.com/open_challenges/147/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				int count = 0;
				int upper = 0;
				int lower = 0;
				
				for (int i = 0; i < line.length(); ++i)
				{
					if (line.substring(i, i+1).matches("[A-Z]"))
					{
						++upper;
					}
					else
					{
						++lower;
					}
					++count;
				}
				
				System.out.println(String.format(Locale.ENGLISH, "lowercase: %.2f uppercase: %.2f", ((float)lower) * 100 / count, ((float)upper) * 100 / count));
			}
		}
	}
}
