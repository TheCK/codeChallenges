package org.ck.codeeval.easy.shortestrepetition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 107, name = "Shortest Repetition", description = "Find the shortest repetition in a string", url = "https://www.codeeval.com/open_challenges/107/", category = "Easy challenges")
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

				int result = line.length();
				for (int i = 1 ; i < line.length(); ++i)
				{
					if (line.matches("(" + line.substring(0, i) + ")+"))
					{
						result = line.substring(0, i).length();
						break;
					}
				}
				
				System.out.println(result);
			}
		}
	}
}