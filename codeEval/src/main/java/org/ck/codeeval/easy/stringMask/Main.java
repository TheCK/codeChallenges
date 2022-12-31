package org.ck.codeeval.easy.stringMask;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Solution(id=199, name="String mask", description="Change case letters by mask", url="https://www.codeeval.com/open_challenges/199/", category="Easy challenges")
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
				String[] input = line.split(" ");

				StringBuilder builder = new StringBuilder();

				for (int i = 0; i < input[0].length(); ++i)
				{
					if ('1' == input[1].charAt(i))
					{
						builder.append(input[0].substring(i, i + 1).toUpperCase());
					}
					else
					{
						builder.append(input[0].charAt(i));
					}
				}

				System.out.println(builder);
			}
		}
	}
}