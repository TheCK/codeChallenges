package org.ck.codeeval.medium.decimaltobinary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 27, name = "Decimal To Binary", description = "Print the binary representation of a decimal number.", url = "https://www.codeeval.com/open_challenges/27/", category = "Moderate challenges")
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
				Integer number = Integer.valueOf(line);
				
				System.out.println(Integer.toBinaryString(number));
			}
		}
	}
}