package org.ck.codeEval.easy.stepwiseWord;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Solution(id=202, name="Stepwise word", description="Print the longest word in a stepwise manner", url="https://www.codeeval.com/open_challenges/202/", category="Easy challenges")
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
				String words[] = line.split(" ");

				String longestWord = "";
				for (String word : words)
				{
					if (word.length() > longestWord.length())
					{
						longestWord = word;
					}
				}

				StringBuilder builder = new StringBuilder();

				int count = 0;
				for (char letter : longestWord.toCharArray())
				{
					for (int i = 0; i < count; ++i)
					{
						builder.append("*");
					}

					builder.append(letter);
					builder.append(" ");

					++count;
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