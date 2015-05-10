package org.ck.codeEval.easy.theMajorElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 132, name = "The Major Element", description = "Find the major element in a sequence", url = "https://www.codeeval.com/open_challenges/132/", category = "Easy challenges")
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
				String[] numbers = line.split(",");
				
				Map<String, Integer> counts = new HashMap<>();
				for (String number : numbers)
				{
					if (counts.containsKey(number))
					{
						counts.put(number, counts.get(number) + 1);
					}
					else
					{
						counts.put(number, 1);
					}
				}
				
				String majorElement = "None";
				for (String key : counts.keySet())
				{
					if (counts.get(key) > numbers.length / 2)
					{
						majorElement = key;
					}
				}
				
				System.out.println(majorElement);
			}	
		}
	}
}
