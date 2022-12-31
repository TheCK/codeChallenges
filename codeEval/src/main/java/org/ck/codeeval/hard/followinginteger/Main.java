package org.ck.codeeval.hard.followinginteger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 44, name = "Following Integer", description = "Determine the next number in a sequence", url = "https://www.codeeval.com/open_challenges/44/", category = "Hard challenges")
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
				Long number = Long.valueOf(line);

				Map<String, Integer> counts = countDigits(number);
				for (Long i = number + 1; i < 10000000; ++i)
				{
					if (counts.equals(countDigits(i)))
					{
						System.out.println(i);
						break;
					}
				}
			}
		}
	}

	private static Map<String, Integer> countDigits(Long number)
	{
		Map<String, Integer> counts = new HashMap<>();

		String numberString = number.toString();

		for (Integer i = 0; i < numberString.length(); ++i)
		{
			String digit = numberString.substring(i, i + 1);

			if (!"0".equals(digit))
			{
				if (counts.containsKey(digit))
				{
					counts.put(digit, counts.get(digit) + 1);
				}
				else
				{
					counts.put(digit, 1);
				}
			}
		}

		return counts;
	}
}