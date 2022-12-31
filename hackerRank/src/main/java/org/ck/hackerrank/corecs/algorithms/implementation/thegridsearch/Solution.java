package org.ck.hackerrank.corecs.algorithms.implementation.thegridsearch;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
		id = 10251,
		name = "The Grid Search",
		url = "https://www.hackerrank.com/challenges/the-grid-search",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int testCases = in.nextInt();

			for (int testCase = 0; testCase < testCases; ++testCase)
			{
				int bigRows = in.nextInt();
				int bigColumns = in.nextInt();
				in.nextLine();

				int[][] bigArray = new int[bigRows][bigColumns];
				for (int i = 0; i < bigRows; ++i)
				{
					String line = in.nextLine();

					for (int j = 0; j < bigColumns; ++j)
					{
						bigArray[i][j] = line.charAt(j) - '0';
					}
				}

				int smallRows = in.nextInt();
				int smallColumns = in.nextInt();
				in.nextLine();

				int[][] smallArray = new int[smallRows][smallColumns];
				for (int i = 0; i < smallRows; ++i)
				{
					String line = in.nextLine();

					for (int j = 0; j < smallColumns; ++j)
					{
						smallArray[i][j] = line.charAt(j) - '0';
					}
				}

				boolean matched = isMatched(bigRows, bigColumns, bigArray, smallRows, smallColumns, smallArray);

				System.out.println(matched ? "YES" : "NO");
			}
		}
	}

	private static boolean isMatched(int bigRows, int bigColumns, int[][] bigArray, int smallRows, int smallColumns, int[][] smallArray)
	{
		for (int bigRow = 0; bigRow < bigRows - smallRows + 1; ++bigRow)
		{
			for (int bigColumn = 0; bigColumn < bigColumns - smallColumns + 1; ++bigColumn)
			{
				boolean matched = true;

				for (int smallRow = 0; smallRow < smallRows; ++smallRow)
				{
					for (int smallColumn = 0; smallColumn < smallColumns; ++smallColumn)
					{
						if (bigArray[bigRow + smallRow][bigColumn + smallColumn] != smallArray[smallRow][smallColumn])
						{
							matched = false;
							break;
						}
					}

					if (!matched)
					{
						break;
					}
				}

				if (matched)
				{
					return true;
				}
			}
		}

		return false;
	}
}