package org.ck.codeeval.medium.arrayAbsurdity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 41, name = "Array Absurdity", description = "Determine if an array contains a duplicated entry", url = "https://www.codeeval.com/open_challenges/41/", category = "Moderate challenges")
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
				String[] array = line.split(";")[1].split(",");
				
				Set<String> numbers = new HashSet<>();
				
				for (String number : array)
				{
					if (numbers.contains(number))
					{
						System.out.println(number);
						break;
					}
					
					numbers.add(number);
				}
			}
		}
	}
}