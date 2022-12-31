package org.ck.codeeval.medium.filenamePattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 169, name = "Filename Pattern", description = "Filter a list of filenames.", url = "https://www.codeeval.com/open_challenges/169/", category = "Moderate challenges")
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
				String[] array = line.split(" ");
				
				String regex = array[0].replaceAll("\\.", "\\\\.");
				regex = regex.replaceAll("\\?", ".");
				regex = regex.replaceAll("\\*", ".*?");
				
				Pattern pattern = Pattern.compile(regex);
				
				StringBuilder builder = new StringBuilder();
				for (Integer i = 1; i < array.length; ++i)
				{
					Matcher matcher = pattern.matcher(array[i]);
					
					if (matcher.matches())
					{
						builder.append(array[i] + " ");
					}
				}
				
				if (builder.length() == 0)
				{
					builder.append("-");
				}
				else
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				
				System.out.println(builder);
			}
		}
	}
}