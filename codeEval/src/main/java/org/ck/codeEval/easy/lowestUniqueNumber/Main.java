package org.ck.codeEval.easy.lowestUniqueNumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 103, name = "Lowest Unique Number", description = "Find the lowest unique number in a set", url = "https://www.codeeval.com/open_challenges/103/", category = "Easy challenges")
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

				Map<Integer, Integer> counts = new TreeMap<>();

				for (String number : numbers)
				{
					Integer integer = Integer.valueOf(number);

					if (!counts.containsKey(integer))
					{
						counts.put(integer, 0);
					}

					counts.put(integer, counts.get(integer) + 1);
				}

				Integer lowest = 0;
				for (Integer key : counts.keySet())
				{
					if (counts.get(key) == 1)
					{
						lowest = key;
						break;
					}
				}

				for (int i = 0; i < numbers.length; ++i)
				{
					if (Integer.valueOf(numbers[i]).equals(lowest))
					{
						System.out.println(i + 1);
						break;
					}
				}
				
				if (lowest == 0)
				{
					System.out.println(0);
				}
			}
		}
	}
}
