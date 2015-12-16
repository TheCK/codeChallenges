package org.ck.codeEval.medium.sequenceTransformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 130, name = "Sequence Transformation", description = "Transform a binary sequence into a string", url = "https://www.codeeval.com/open_challenges/130/", category = "Moderate challenges", solved = false)
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
				
				Stack<Position> queue = new Stack<>();
				queue.push(new Position(0, 0, 'x'));

				while (!queue.isEmpty())
				{
					Position position = queue.pop();

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

					char currentPattern = pattern.charAt(patternPosition);
					char currentResult = result.charAt(resultPosition);

					if (currentPattern == '0')
					{
						if (currentResult == 'A')
						{
							queue.push(new Position(patternPosition, resultPosition + 1, 'x'));
							queue.push(new Position(patternPosition + 1, resultPosition + 1, 'x'));
						}
						
						continue;
					}

					/* currentPattern is 1 here */
					
					char lastChoice = position.getLastChoice();

					if (lastChoice != 'x')
					{
						if (currentResult == lastChoice)
						{
							queue.push(new Position(patternPosition, resultPosition + 1, lastChoice));
							queue.push(new Position(patternPosition + 1, resultPosition + 1, 'x'));
						}
						
						continue;
					}
					
					/* pattern is 1 here and we had no former choice */
					queue.push(new Position(patternPosition, resultPosition + 1, currentResult));
					queue.push(new Position(patternPosition + 1, resultPosition + 1, 'x'));
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

		private char lastChoice;

		public Position(int patternPosition, int resultPosition, char lastChoice)
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

		public char getLastChoice()
		{
			return this.lastChoice;
		}
	}
}