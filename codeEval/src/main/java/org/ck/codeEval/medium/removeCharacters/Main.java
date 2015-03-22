package org.ck.codeEval.medium.removeCharacters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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