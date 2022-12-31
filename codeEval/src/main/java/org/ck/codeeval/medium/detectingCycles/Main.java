package org.ck.codeeval.medium.detectingCycles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 5, name = "Detecting Cycles", description = "Detecting loops within a sequence.", url = "https://www.codeeval.com/open_challenges/5/", category = "Moderate challenges")
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
				String[] numbers = line.split(" ");

				Set<String> occurances = new TreeSet<>();
				String firstMatch = null;
				for (String number : numbers)
				{
					if (occurances.contains(number))
					{
						firstMatch = number;
						break;
					}

					occurances.add(number);
				}

				StringBuilder builder = new StringBuilder();
				Boolean started = false;
				for (String number : numbers)
				{
					if (started && number.equals(firstMatch))
					{
						break;
					}
					
					if (number.equals(firstMatch))
					{
						started = true;
					}

					if (started)
					{
						builder.append(number);
						builder.append(" ");
					}
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