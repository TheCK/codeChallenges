package org.ck.codeeval.medium.buildersteam;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 218, name = "Builders team.", description = "Count all squares on the map.", url = "https://www.codeeval.com/open_challenges/218/", category = "Moderate challenges")
public class Main
{
	private static String[] grid = new String[25];

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] pipes = line.split("\\|");

				initGrid();

				for (String pipe : pipes)
				{
					String[] coordinates = pipe.trim().split(" ");
					int first = Integer.parseInt(coordinates[0]) - 1;
					int second = Integer.parseInt(coordinates[1]) - 1;

					if (second < first)
					{
						int temp = first;
						first = second;
						second = temp;
					}

					if ((second - first) == 5)
					{
						grid[first] += "d";
						grid[second] += "u";
					}
					else
					{
						grid[first] += "r";
						grid[second] += "l";
					}
				}

				int count = 0;

				for (int i = 0; i < 5; ++i)
				{
					for (int j = 0; j < 5; ++j)
					{
						count += count(i, j, 0, 0, null);
					}
				}

				System.out.println(count);
			}
		}
	}

	private static int count(int i, int j, int stepsRight, int stepsDown, Direction lastDirection)
	{
		int cell = 5 * i + j;

		if (cell >= 25 || stepsDown < 0 || stepsRight < 0 || i < 0 || i > 4 || j < 0 || j > 4)
		{
			return 0;
		}

		int count = 0;

		if (stepsDown == 0 && stepsRight == 0 && lastDirection == Direction.UP)
		{
			return 1;
		}

		if (grid[cell].contains("r") && (lastDirection == null || lastDirection == Direction.RIGHT))
		{
			count += count(i, j + 1, stepsRight + 1, stepsDown, Direction.RIGHT);
		}
		if (grid[cell].contains("d") && (lastDirection == Direction.RIGHT || lastDirection == Direction.DOWN))
		{
			count += count(i + 1, j, stepsRight, stepsDown + 1, Direction.DOWN);
		}
		if (grid[cell].contains("l") && ((lastDirection == Direction.DOWN && stepsDown == stepsRight) || lastDirection == Direction.LEFT))
		{
			count += count(i, j - 1, stepsRight - 1, stepsDown, Direction.LEFT);
		}
		if (grid[cell].contains("u") && (lastDirection == Direction.LEFT || lastDirection == Direction.UP) && stepsRight == 0)
		{
			count += count(i - 1, j, stepsRight, stepsDown - 1, Direction.UP);
		}

		return count;
	}

	private static void initGrid()
	{
		for (int i = 0; i < 25; ++i)
		{
			grid[i] = "";
		}
	}

	private enum Direction
	{
		RIGHT, DOWN, LEFT, UP;
	}
}