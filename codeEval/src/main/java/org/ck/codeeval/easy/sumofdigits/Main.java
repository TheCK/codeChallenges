package org.ck.codeeval.easy.sumofdigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 21, name = "Sum of Digits", description = "Sum of digits comprising a number", url = "https://www.codeeval.com/open_challenges/21/", category = "Easy challenges")
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
				
				Integer sum = 0;
				
				for (int i = 0; i < line.length(); ++i)
				{
					sum += Integer.parseInt(line.substring(i, i + 1));
				}
				
				System.out.println(sum);
			}
		}
	}
}
