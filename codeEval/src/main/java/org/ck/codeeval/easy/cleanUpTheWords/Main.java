package org.ck.codeeval.easy.cleanUpTheWords;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(id = 205, name = "Clean up the words", description = "Print the words separated by spaces", url = "https://www.codeeval.com/open_challenges/205/", category = "Easy challenges")
public class Main
{
	private static Pattern pattern = Pattern.compile("[a-zA-Z]+");

	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				StringBuilder builder = new StringBuilder();

				Matcher matcher = pattern.matcher(line);
				while (matcher.find())
				{
					builder.append(matcher.group().toLowerCase())
							.append(" ");
				}

				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				System.out.println(builder);
			}
		}
	}
}