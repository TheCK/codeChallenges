package org.ck.codeeval.easy.withoutRepetitions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 173, name = "Without Repetitions", description = "Delete characters that are consistently repeated.", url = "https://www.codeeval.com/open_challenges/173/", category = "Easy challenges")
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

				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < line.length(); ++i)
				{
					if (builder.length() == 0)
					{
						builder.append(line.subSequence(i, i + 1));
					}
					else
					{
						if(!builder.substring(builder.length() - 1).equals(line.substring(i, i + 1)))
						{
							builder.append(line.subSequence(i, i + 1));
						}
					}
				}

				System.out.println(builder);
			}
		}
	}
}