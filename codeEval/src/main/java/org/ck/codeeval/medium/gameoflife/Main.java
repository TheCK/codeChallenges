package org.ck.codeeval.medium.gameoflife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 161, name = "Game of Life", description = "Implement the classical cellular automaton game.", url = "https://www.codeeval.com/open_challenges/161/", category = "Moderate challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			boolean[][] field = null;
			int row = 0;

			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();

				if (field == null)
				{
					field = new boolean[line.length()][line.length()];
				}

				for (int column = 0; column < line.length(); ++column)
				{
					field[row][column] = line.substring(column, column + 1).equals("*");
				}

				++row;
			}

			for (int i = 0; i < 10; ++i)
			{
				field = live(field);
			}

			if (field != null)
			{
				for (row = 0; row < field.length; ++row)
				{
					for (int column = 0; column < field[row].length; ++column)
					{
						System.out.print(field[row][column] ? "*" : ".");
					}

					System.out.println("");
				}
			}
		}
	}

	private static boolean[][] live(boolean[][] field)
	{
		boolean[][] newField = new boolean[field.length][field.length];

		for (int row = 0; row < field.length; ++row)
		{
			for (int column = 0; column < field[row].length; ++column)
			{
				int count = count(field, row, column);

				if (count == 3 && !field[row][column])
				{
					newField[row][column] = true;
				}
				else if (field[row][column] && (count == 2 || count == 3))
				{
					newField[row][column] = true;
				}
				else
				{
					newField[row][column] = false;
				}
			}
		}

		return newField;
	}

	private static int count(boolean[][] field, int row, int column)
	{
		int count = 0;

		if (row > 0 && column > 0 && field[row - 1][column - 1])
		{
			++count;
		}
		if (row > 0 && field[row - 1][column])
		{
			++count;
		}
		if (row > 0 && column < field.length - 1 && field[row - 1][column + 1])
		{
			++count;
		}
		if (column > 0 && field[row][column - 1])
		{
			++count;
		}
		if (column < field.length - 1 && field[row][column + 1])
		{
			++count;
		}
		if (row < field.length - 1 && column > 0 && field[row + 1][column - 1])
		{
			++count;
		}
		if (row < field.length - 1 && field[row + 1][column])
		{
			++count;
		}
		if (row < field.length - 1 && column < field.length - 1 && field[row + 1][column + 1])
		{
			++count;
		}

		return count;
	}
}