package org.ck.codeeval.easy.rollercoaster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 156, name = "Roller Coaster", description = "Turn the text into RoLlErCoAsTeR case.", url = "https://www.codeeval.com/open_challenges/156/", category = "Easy challenges")
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
				int counter = 0;
				for (int i = 0; i < line.length(); ++i)
				{
					String letter = line.substring(i, i+1);
					if (letter.matches("[a-zA-Z]"))
					{
						if (counter % 2 == 0)
						{
							builder.append(letter.toUpperCase());
						}
						else
						{
							builder.append(letter.toLowerCase());
						}
						
						++counter;
					}
					else
					{
						builder.append(letter);
					}
				}
				
				System.out.println(builder);
			}
		}
	}
}
