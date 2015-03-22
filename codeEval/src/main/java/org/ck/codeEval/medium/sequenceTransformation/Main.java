package org.ck.codeEval.medium.sequenceTransformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 130, name = "Sequence Transformation", description = "Transform a binary sequence into a string", url = "https://www.codeeval.com/open_challenges/130/", category = "Moderate callenges", solved = false)
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
				long start = System.currentTimeMillis();
				line = line.trim();
				String[] array = line.split(" ");

				String pattern = array[0];
				String result = array[1];

				boolean matches = false;
				
				Queue<Position> queue = new LinkedList<>();
				queue.add(new Position(0, 0, null));

				while (!queue.isEmpty())
				{
					Position position = queue.remove();

					int patternPosition = position.getPatternPosition();
					int resultPosition = position.getResultPosition();

					if (patternPosition == pattern.length() && resultPosition == result.length())
					{
						matches = true;
						break;
					}

					if (patternPosition == pattern.length())
					{
						continue;
					}

					if (resultPosition == result.length())
					{
						continue;
					}

					String currentPattern = pattern.substring(patternPosition, patternPosition + 1);
					String currentResult = result.substring(resultPosition, resultPosition + 1);

					if (currentPattern.equals("0"))
					{
						if (currentResult.equals("A"))
						{
							queue.add(new Position(patternPosition, resultPosition + 1, null));
							queue.add(new Position(patternPosition + 1, resultPosition + 1, null));
						}
						
						continue;
					}

					/* currentPattern is 1 here */
					
					String lastChoice = position.getLastChoice();

					if (lastChoice != null)
					{
						if (currentResult.equals(lastChoice))
						{
							queue.add(new Position(patternPosition, resultPosition + 1, lastChoice));
							queue.add(new Position(patternPosition + 1, resultPosition + 1, null));
						}
						
						continue;
					}
					
					/* pattern is 1 here and we had no former choice */
					queue.add(new Position(patternPosition, resultPosition + 1, currentResult));
					queue.add(new Position(patternPosition + 1, resultPosition + 1, null));
				}

				System.out.println(matches ? "Yes" : "No");
				System.err.println((System.currentTimeMillis() - start) + " for " + line);
			}
		}
	}

	private static class Position
	{
		private int patternPosition;
		private int resultPosition;

		private String lastChoice;

		public Position(int patternPosition, int resultPosition, String lastChoice)
		{
			this.patternPosition = patternPosition;
			this.resultPosition = resultPosition;

			this.lastChoice = lastChoice;
		}

		public int getPatternPosition()
		{
			return this.patternPosition;
		}

		public int getResultPosition()
		{
			return this.resultPosition;
		}

		public String getLastChoice()
		{
			return this.lastChoice;
		}
	}
}