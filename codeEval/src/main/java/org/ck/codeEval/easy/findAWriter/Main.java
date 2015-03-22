package org.ck.codeEval.easy.findAWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 97, name = "Find a Writer", description = "Find a famous writer in a string", url = "https://www.codeeval.com/open_challenges/97/", category = "Easy callenges")
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
				String[] words = line.split("\\|");
				String garbage = words[0];
				
				String[] indices = words[1].split(" ");

				StringBuilder builder = new StringBuilder();
				for (String index : indices)
				{
					try
					{
						Integer pos = Integer.valueOf(index);
						
						builder.append(garbage.substring(pos - 1, pos));
					}
					catch (NumberFormatException e)
					{
						//Do nothing
					}
				}

				System.out.println(builder);
			}
		}
	}
}
