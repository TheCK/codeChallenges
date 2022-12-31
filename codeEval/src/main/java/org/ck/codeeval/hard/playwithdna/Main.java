package org.ck.codeeval.hard.playwithdna;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Solution(
		id = 126,
		name = "Play with DNA",
		description = "Write an algorithm that a finds DNA segment in a given DNA string",
		url = "https://www.codeeval.com/open_challenges/126/",
		category = "Hard challenges",
		solved = false
)
public class Main
{
	private static Map<String, Integer> cache = new HashMap<>();

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] arguments = line.split(" ");

				String wanted = arguments[0];
				int mismatch = Integer.parseInt(arguments[1]);
				String input = arguments[2];

				Map<Integer, List<String>> matches = new TreeMap<>();
				for (int i = 0; i < input.length() - wanted.length() + 1; ++i)
				{
					String candidate = input.substring(i, i + wanted.length());
					Integer distance = levenshtein(candidate, wanted);

					if (distance.intValue() <= mismatch)
					{
						if (!matches.containsKey(distance))
						{
							matches.put(distance, new ArrayList<>());
						}

						matches.get(distance).add(candidate);
					}
				}

				if (matches.size() == 0)
				{
					System.out.println("No match");
					continue;
				}

				StringBuilder builder = new StringBuilder();
				for (Integer distance : matches.keySet())
				{
					Collections.sort(matches.get(distance));
					for (String match : matches.get(distance))
					{
						builder.append(match + " ");
					}
				}

				builder.deleteCharAt(builder.length() - 1);
				System.out.println(builder);
			}
		}
	}

	private static int levenshtein(String a, String b)
	{
		if (a.equals(b))
		{
			return 0;
		}

		if (a.equals(""))
		{
			return b.length();
		}

		if (b.equals(""))
		{
			return a.length();
		}

		if (a.substring(0, 1).equals(b.substring(0, 1)))
		{
			return levenshtein(a.substring(1), b.substring(1));
		}

		String key = a + " " + b;
		if (cache.containsKey(key))
		{
			return cache.get(key);
		}

		int lefSub = levenshtein(a.substring(1), b.substring(1));
		int lefDelA = levenshtein(a.substring(1), b);
		int lefDelB = levenshtein(a, b.substring(1));

		int distance = 1 + Math.min(Math.min(lefDelA, lefDelB), lefSub);
		cache.put(key, distance);

		return distance;
	}
}