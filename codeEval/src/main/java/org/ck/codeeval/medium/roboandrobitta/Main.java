package org.ck.codeeval.medium.roboandrobitta;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 212, name = "Robo and Robitta", description = "Count all nuts.", url = "https://www.codeeval.com/open_challenges/212/", category = "Moderate challenges")
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
				String[] arguments = line.split("\\|");
				
				String[] dimensions = arguments[0].trim().split("x");
				String[] goal = arguments[1].trim().split(" ");

				int width = Integer.parseInt(dimensions[0]);
				int height = Integer.parseInt(dimensions[1]);

				int goalX = Integer.parseInt(goal[0]);
				int goalY = Integer.parseInt(goal[1]);

				int nuts = solve(width, height, goalX, height - goalY + 1);

				System.out.println(nuts);
			}
		}
	}

	private static int solve(int width, int height, int goalX, int goalY)
	{
		int nuts = 0;

		if (goalY == 1)
		{
			nuts += goalX;
		}
		else
		{
			nuts += width;

			if (goalX == width)
			{
				nuts += goalY - 1;
			}
			else
			{
				nuts += height - 1;

				if (goalY == height)
				{
					nuts += (width - goalX);
				}
				else
				{
					nuts += width - 1;

					if (goalX == 1)
					{
						nuts += (height - goalY);
					}
					else
					{
						nuts += height - 2 + solve(width - 2, height - 2, goalX - 1, goalY - 1);
					}
				}
			}
		}

		return nuts;
	}
}