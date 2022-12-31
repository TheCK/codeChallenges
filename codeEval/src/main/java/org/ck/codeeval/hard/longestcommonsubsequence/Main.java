package org.ck.codeeval.hard.longestcommonsubsequence;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Solution(id = 6, name = "Longest Common Subsequence", description = "LCS between two strings.", url = "https://www.codeeval.com/open_challenges/6/", category = "Hard challenges")
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
				String[] arguments = line.split(";");

				List<String> subsequences = new ArrayList<>();

				Queue<Position> queue = new LinkedList<>();
				queue.add(new Position(0, 0, ""));

				while (!queue.isEmpty())
				{
					Position position = queue.remove();

					int position1 = position.getPosition1();
					int position2 = position.getPosition2();
					String currentSequence = position.getCurrentSequence();

					if (position1 == arguments[0].length())
					{
						subsequences.add(currentSequence);
						continue;
					}

					if (position2 == arguments[1].length())
					{
						subsequences.add(currentSequence);
						continue;
					}

					if (arguments[0].charAt(position1) == arguments[1].charAt(position2))
					{
						queue.add(new Position(position1 + 1, position2 + 1, currentSequence + arguments[0].charAt(position1)));
						continue;
					}

					queue.add(new Position(position1 + 1, position2, currentSequence));
					queue.add(new Position(position1, position2 + 1, currentSequence));
				}

				String lcs = "";

				for (String candidate : subsequences)
				{
					if (candidate.length() > lcs.length())
					{
						lcs = candidate;
					}
				}

				System.out.println(lcs);
			}
		}
	}

	private static class Position
	{
		private int position1;
		private int position2;

		private String currentSequence;

		public Position(int position1, int position2, String currentSequence)
		{
			this.position1 = position1;
			this.position2 = position2;

			this.currentSequence = currentSequence;
		}

		public int getPosition1()
		{
			return this.position1;
		}

		public int getPosition2()
		{
			return this.position2;
		}

		public String getCurrentSequence()
		{
			return this.currentSequence;
		}
	}
}