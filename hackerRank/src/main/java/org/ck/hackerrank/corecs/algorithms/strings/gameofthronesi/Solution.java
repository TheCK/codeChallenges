package org.ck.hackerrank.corecs.algorithms.strings.gameofthronesi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10319,
		name = "Game of Thrones - I",
		url = "https://www.hackerrank.com/challenges/game-of-thrones",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String potentialWord = in.nextLine();

			Map<String, Integer> map = new HashMap<>();

			for (Integer i = 0; i < potentialWord.length(); ++i)
			{
				String character = potentialWord.substring(i, i + 1);

				if (map.containsKey(character))
				{
					map.put(character, map.get(character) + 1);
				}
				else
				{
					map.put(character, 1);
				}
			}

			Boolean possible = true;
			Boolean unevenOccurences = false;

			for (String key : map.keySet())
			{
				if (map.get(key) % 2 != 0)
				{
					if (unevenOccurences)
					{
						possible = false;
						break;
					}

					unevenOccurences = true;
				}
			}

			System.out.println(possible ? "YES" : "NO");
		}
	}
}