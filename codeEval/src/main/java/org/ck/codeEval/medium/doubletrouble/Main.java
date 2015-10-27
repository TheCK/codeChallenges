package org.ck.codeEval.medium.doubletrouble;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 215, name = "Double trouble", description = "Calculate the number of correct variants for messages.", url = "https://www.codeeval.com/open_challenges/215/", category = "Moderate challenges")
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
				String firstHalf = line.substring(0, line.length() / 2);
				String secondHalf = line.substring(line.length() / 2, line.length());

				int combinations = 1;

				for (int i = 0; i < firstHalf.length(); ++i)
				{
					char charInFirstHalf = firstHalf.charAt(i);
					char charInSecondHalf = secondHalf.charAt(i);

					if ('*' == charInFirstHalf && '*' == charInSecondHalf)
					{
						combinations *= 2;
					}
					else if ('*' != charInFirstHalf && '*' != charInSecondHalf && charInFirstHalf != charInSecondHalf)
					{
						combinations = 0;
						break;
					}
				}

				System.out.println(combinations);
			}
		}
	}
}