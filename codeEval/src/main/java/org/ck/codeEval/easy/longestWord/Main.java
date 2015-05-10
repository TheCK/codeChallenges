package org.ck.codeEval.easy.longestWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 111, name = "Longest Word", description = "Get the longest word in a sentence", url = "https://www.codeeval.com/open_challenges/111/", category = "Easy challenges")
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

				String result = "";
				for (String word : words)
				{
					if (word.length() > result.length())
					{
						result = word;
					}
				}
				
				System.out.println(result);
			}
		}
	}
}
