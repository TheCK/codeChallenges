package org.ck.codeeval.medium.balancedsmileys;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 84, name = "Balanced Smileys", description = "Facebook Hacker Cup 2013 problem.", url = "https://www.codeeval.com/open_challenges/84/", category = "Moderate challenges")
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

				boolean matches = walkString(line, 0, 0, false);

				System.out.println(matches ? "YES" : "NO");
			}
		}
	}

	private static boolean walkString(String line, int position, int openings, boolean smileyCandidate)
	{
		if (openings < 0)
		{
			return false;
		}

		if (position == line.length())
		{
			return openings == 0;
		}

		char character = line.charAt(position);

		if (smileyCandidate)
		{
			if (character == '(')
			{
				return walkString(line, position + 1, openings, false)
					|| walkString(line, position + 1, openings + 1, false);
			}

			if (character == ')')
			{
				return walkString(line, position + 1, openings, false)
					|| walkString(line, position + 1, openings - 1, false);
			}

			return walkString(line, position + 1, openings, character == ':');
		}

		if (character == '(')
		{
			return walkString(line, position + 1, openings + 1, false);
		}

		if (character == ')')
		{
			return walkString(line, position + 1, openings - 1, false);
		}

		return walkString(line, position + 1, openings, character == ':');
	}
}