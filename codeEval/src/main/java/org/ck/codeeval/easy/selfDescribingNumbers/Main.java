package org.ck.codeeval.easy.selfDescribingNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 40, name = "Self Describing Numbers", description = "Determine if a number is a self-describing number or not", url = "https://www.codeeval.com/open_challenges/40/", category = "Easy challenges")
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

				Map<String, Integer> counts = new HashMap<>();
				for (Integer i = 0; i < line.length(); ++i)
				{
					String digit = line.substring(i, i + 1);

					if (counts.containsKey(digit))
					{
						counts.put(digit, counts.get(digit) + 1);
					}
					else
					{
						counts.put(digit, 1);
					}
				}

				for (Integer i = 0; i < 10; ++i)
				{
					if (!counts.containsKey(i.toString()))
					{
						counts.put(i.toString(), 0);
					}
				}

				Boolean isSelfDescribing = true;
				for (String digit : counts.keySet())
				{
					Integer position = Integer.valueOf(digit);

					if (counts.get(digit) > 0)
					{
						if (position >= line.length())
						{
							isSelfDescribing = false;
							break;
						}

						if (counts.get(digit) != Integer.valueOf(line.substring(position, position + 1)))
						{
							isSelfDescribing = false;
							break;
						}
					}
				}

				System.out.println(isSelfDescribing ? 1 : 0);
			}
		}
	}
}