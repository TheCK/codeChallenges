package org.ck.codeEval.easy.reverseWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 8, name = "Reverse words", description = "Reversing an input sequence of words.", url = "https://www.codeeval.com/open_challenges/8/", category = "Easy callenges")
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
				for (int i = words.length - 1; i >= 0; --i)
				{
					builder.append(words[i]);
					builder.append(" ");
				}
				
				builder.deleteCharAt(builder.length() - 1);
				System.out.println(builder);
			}
		}
	}
}
