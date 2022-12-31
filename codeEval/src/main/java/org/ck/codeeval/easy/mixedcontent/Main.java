package org.ck.codeeval.easy.mixedcontent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 115, name = "Mixed Content", description = "Separate words with digits", url = "https://www.codeeval.com/open_challenges/115/", category = "Easy challenges")
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
				String[] stuffs = line.split(",");

				List<String> words = new ArrayList<>();
				List<String> numbers = new ArrayList<>();

				for (String stuff : stuffs)
				{
					try
					{
						Integer.valueOf(stuff);
						numbers.add(stuff);
					}
					catch (NumberFormatException e)
					{
						words.add(stuff);
					}
				}

				StringBuilder result = new StringBuilder();
				if (words.size() > 0)
				{
					for (String word : words)
					{
						result.append(word);
						result.append(",");
					}
					
					result.deleteCharAt(result.length() - 1);
				}
				if (words.size() > 0 && numbers.size() > 0)
				{
					result.append("|");
				}
				if (numbers.size() > 0)
				{
					for (String number : numbers)
					{
						result.append(number);
						result.append(",");
					}
					
					result.deleteCharAt(result.length() - 1);
				}

				System.out.println(result);
			}
		}
	}
}