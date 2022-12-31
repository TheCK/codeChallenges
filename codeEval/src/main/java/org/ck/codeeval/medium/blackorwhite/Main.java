package org.ck.codeeval.medium.blackorwhite;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 209, name = "Black or white", description = "Find the smallest submatrix", url = "https://www.codeeval.com/open_challenges/209/", category = "Moderate challenges")
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
				String[] rows = line.split("\\|");

				boolean[][] cars = new boolean[rows.length][rows.length];

				int i = 0;
				for (String row : rows)
				{
					String[] fields = row.trim().split("");

					int j = 0;
					for (String field : fields)
					{
						if ("".equals(field))
						{
							continue;
						}

						cars[i][j] = "1".equals(field);
						++j;
					}
					++i;
				}

				int smallestSize = 0;
				int blackCarsInSmallestMatrix = 0;

				for (i = 1; i <= cars.length; ++i)
				{
					boolean currentSizeFits = true;
					int blackCarsForSize = count(cars, 0, 0, i);

					for (int x = 0; x <= cars.length - i; ++x)
					{
						for (int y = 0; y <= cars.length - i; ++y)
						{
							if (blackCarsForSize != count(cars, x, y, i))
							{
								currentSizeFits = false;
							}
						}
					}

					if (currentSizeFits)
					{
						smallestSize = i;
						blackCarsInSmallestMatrix = blackCarsForSize;
						break;
					}
				}

				System.out.println(String.format("%dx%d, %d", smallestSize, smallestSize, blackCarsInSmallestMatrix));
			}
		}
	}

	private static int count(boolean[][] cars, int xStart, int yStart, int size)
	{
		int count = 0;

		for (int x = xStart; x < xStart + size; ++x)
		{
			for (int y = yStart; y < yStart + size; ++y)
			{
				if (cars[x][y])
				{
					++count;
				}
			}
		}

		return count;
	}
}