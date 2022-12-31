package org.ck.codeeval.easy.hexToDecimal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 67, name = "Hex to Decimal", description = "Convert a hex number to it's decimal equivalent.", url = "https://www.codeeval.com/open_challenges/67/", category = "Easy challenges")
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

				System.out.println(Integer.parseInt(line, 16));
			}
		}
	}
}
