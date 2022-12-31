package org.ck.codeeval.easy.simpleSorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 91, name = "Simple Sorting", description = "Sort several numbers", url = "https://www.codeeval.com/open_challenges/91/", category = "Easy challenges")
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
				String[] numbers = line.split(" ");
				
				Set<Float> set = new TreeSet<>();
				
				for(String number : numbers)
				{
					set.add(Float.valueOf(number));
				}
				
				StringBuilder builder = new StringBuilder();
				for(Float number : set)
				{
					builder.append(String.format(Locale.ENGLISH, "%.3f", number));
					builder.append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				
				System.out.println(builder);
			}
		}
	}
}
