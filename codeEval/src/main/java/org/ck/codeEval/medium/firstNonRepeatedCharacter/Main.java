package org.ck.codeEval.medium.firstNonRepeatedCharacter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

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

				Map<String, Integer> letterCounts = new LinkedHashMap<>();
				for (int i = 0; i < line.length(); ++i)
				{
					String letter = line.substring(i, i + 1);
					
					if (letterCounts.containsKey(letter))
					{
						letterCounts.put(letter, letterCounts.get(letter) + 1);
					}
					else
					{
						letterCounts.put(letter, 1);
					}
				}
				
				for (String letter : letterCounts.keySet())
				{
					if (letterCounts.get(letter) == 1)
					{
						System.out.println(letter);
						break;
					}
				}
			}
		}
	}
}