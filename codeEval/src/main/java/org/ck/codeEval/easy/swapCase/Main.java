package org.ck.codeEval.easy.swapCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 96, name = "Swap Case", description = "Swap case in a string", url = "https://www.codeeval.com/open_challenges/96/", category = "Easy challenges")
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
				String[] words = line.split(" ");

				StringBuilder builder = new StringBuilder();
				for (String word : words)
				{
					builder.append(swap(word));
					builder.append(" ");
				}

				builder.deleteCharAt(builder.length() - 1);
				System.out.println(builder);
			}
		}
	}

	private static Object swap(String word)
	{
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < word.length(); ++i)
		{
			String letter = word.substring(i, i+1);
			
			if (letter.matches("[A-Z]"))
			{
				builder.append(letter.toLowerCase());
			}
			else
			{
				builder.append(letter.toUpperCase());
			}
		}
		
		return builder;
	}
}
