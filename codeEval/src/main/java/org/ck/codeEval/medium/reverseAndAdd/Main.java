package org.ck.codeEval.medium.reverseAndAdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 45, name = "Reverse and Add", description = "Continually add a number to its reverse to arrive at a palindrome", url = "https://www.codeeval.com/open_challenges/45/", category = "Moderate challenges")
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
				
				Integer additions = 0;
				while(!isPalindrome(line))
				{
					StringBuilder builder = new StringBuilder(line);
					builder.reverse();
					Integer sum = Integer.parseInt(line) + Integer.parseInt(builder.toString());
					
					line = sum.toString();
					++additions;
				}
				
				System.out.println(additions + " " + line);
			}
		}
	}

	private static boolean isPalindrome(String line)
	{
		StringBuilder builder = new StringBuilder(line);
		builder.reverse();
		
		return builder.toString().equals(line);
	}
}