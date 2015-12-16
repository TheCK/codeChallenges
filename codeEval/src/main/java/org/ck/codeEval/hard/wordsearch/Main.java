package org.ck.codeEval.hard.wordsearch;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

@Solution(id = 65, name = "Word Search", description = "Find if a word exists in a grid", url = "https://www.codeeval.com/open_challenges/65/", category = "Hard challenges")
public class Main
{
	private static final char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				char[] letters = line.toCharArray();

				boolean possible = false;

				for (int y = 0; y < board.length; ++y)
				{
					for (int x = 0; x < board[y].length; ++x)
					{
						boolean[][] visited = new boolean[3][4];

						possible = checkIfWordIsPossible(letters, y, x, visited);

						if (possible)
						{
							break;
						}
					}

					if (possible)
					{
						break;
					}
				}

				System.out.println(possible ? "True" : "False");
			}
		}
	}

	private static boolean checkIfWordIsPossible(char[] letters, int y, int x, boolean[][] visited)
	{
		if (letters.length == 0)
		{
			return true;
		}

		if (letters[0] == board[y][x] && !visited[y][x])
		{
			visited[y][x] = true;

			letters = Arrays.copyOfRange(letters, 1, letters.length);

			boolean possible = false;

			if (y > 0)
			{
				possible = possible || checkIfWordIsPossible(letters, y - 1, x, visited);
			}

			if (x > 0)
			{
				possible = possible || checkIfWordIsPossible(letters, y, x - 1, visited);
			}

			if (x < board[y].length - 1)
			{
				possible = possible || checkIfWordIsPossible(letters, y, x + 1, visited);
			}

			if (y < board.length - 1)
			{
				possible = possible || checkIfWordIsPossible(letters, y + 1, x, visited);
			}

			return possible;
		}

		return false;
	}
}