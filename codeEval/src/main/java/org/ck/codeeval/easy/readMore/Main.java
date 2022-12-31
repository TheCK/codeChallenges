package org.ck.codeeval.easy.readMore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 167, name = "Read More", description = "Limit the length of the text.", url = "https://www.codeeval.com/open_challenges/167/", category = "Easy challenges")
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

				if (line.length() > 55)
				{
					line = line.substring(0, 40);
					if(line.contains(" "))
					{
						line = line.substring(0, line.lastIndexOf(" ")).trim();
					}
					
					line += "... <Read More>";
				}

				System.out.println(line);
			}
		}
	}
}