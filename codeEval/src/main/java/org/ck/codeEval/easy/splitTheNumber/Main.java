package org.ck.codeEval.easy.splitTheNumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 131, name = "Split The Number", description = "Evaluate the number according to the pattern", url = "https://www.codeeval.com/open_challenges/131/", category = "Easy challenges")
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
				String[] arguments = line.split(" ");

				String number = arguments[0].trim();
				String pattern = arguments[1].trim();
				
				Integer result = 0;
				if (pattern.contains("+"))
				{
					result = Integer.valueOf(number.substring(0, pattern.indexOf("+"))) + Integer.valueOf(number.substring(pattern.indexOf("+")));
				}
				else if(pattern.contains("-"))
				{
					result = Integer.valueOf(number.substring(0, pattern.indexOf("-"))) - Integer.valueOf(number.substring(pattern.indexOf("-")));
				}
				
				System.out.println(result);
			}
		}
	}
}
