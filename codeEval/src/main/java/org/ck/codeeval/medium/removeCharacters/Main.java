package org.ck.codeeval.medium.removeCharacters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 13, name = "Remove Characters", description = "Delete specific characters from a string.", url = "https://www.codeeval.com/open_challenges/13/", category = "Moderate challenges")
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
				String[] arguments = line.split(",");

				String sentence = arguments[0];
				String[] letters = arguments[1].trim().split("");
				for (String letter : letters)
				{
					sentence = sentence.replaceAll(letter, "");
				}
				
				System.out.println(sentence);
			}
		}
	}
}