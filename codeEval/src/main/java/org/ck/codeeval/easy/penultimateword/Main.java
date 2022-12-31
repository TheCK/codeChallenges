package org.ck.codeeval.easy.penultimateword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 92, name = "Penultimate Word", description = "Find the next-to-last word", url = "https://www.codeeval.com/open_challenges/92/", category = "Easy challenges")
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

				System.out.println(words[words.length - 2]);
			}
		}
	}
}
