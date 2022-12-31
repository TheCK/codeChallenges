package org.ck.codeeval.easy.swapNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id=196, name="Swap Numbers", description="Swap numbers surrounding a word", url="https://www.codeeval.com/open_challenges/196/", category="Easy challenges")
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
				String[] words = line.split(" ");
				
				StringBuilder builder = new StringBuilder();
				for (String word : words)
				{
					builder.append(word.substring(word.length() - 1));
					builder.append(word.substring(1, word.length() - 1));
					builder.append(word.substring(0, 1));
					builder.append(" ");
				}
				
				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				
				System.out.println(builder);
			}
		}
	}
}