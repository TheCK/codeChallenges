package org.ck.codeeval.medium.trailingstring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 32, name = "Trailing String", description = "Determine if a string 'B' occurs at the end of string 'A'", url = "https://www.codeeval.com/open_challenges/32/", category = "Moderate challenges")
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
				String[] values = line.split(",");
				
				System.out.println(values[0].endsWith(values[1]) ? 1 : 0);
			}
		}
	}
}