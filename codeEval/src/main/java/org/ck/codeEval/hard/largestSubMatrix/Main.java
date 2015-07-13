package org.ck.codeEval.hard.largestSubMatrix;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Solution(id = 105, name = "Largest Sub-Matrix", description = "Determine the largest sub-matrix in a matrix", url = "https://www.codeeval.com/open_challenges/105/", category = "Hard challenges")
public class Main
{
	private static int maxSum = Integer.MIN_VALUE;

	private static int[][] matrix;

	private static Set<Character> letters;

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			List<String> input = new ArrayList<>();

			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();

				input.add(line);
			}

			matrix = new int[input.size()][];
			int y = 0;

			for (String toConvert : input)
			{
				String[] numberStrings = toConvert.split(" ");
				int[] numbersInLine = new int[numberStrings.length];

				for(int i = 0; i < numberStrings.length; ++i)
				{
					numbersInLine[i] = Integer.parseInt(numberStrings[i]);
				}

				matrix[y++] = numbersInLine;
			}
			
			walk();
			System.out.println(maxSum);
		}
	}

	private static void walk()
	{
		for (int x = 0; x < matrix[0].length; ++x)
		{
			for (int y = 0; y < matrix.length; ++y)
			{
				for (int width = 0; width + x < matrix[0].length; ++width)
				{
					for (int height = 0; height + y < matrix.length; ++height)
					{
						int sum = getSum(x, y, width, height);

						if (sum > maxSum)
						{
							maxSum = sum;
						}
					}
				}
			}
		}
	}

	private static int getSum(int x, int y, int width, int height)
	{
		int sum = 0;

		for (int i = x; i <= x + width; ++i)
		{
			for (int j = y; j <= y + height; ++j)
			{
				sum += matrix[j][i];
			}
		}

		return sum;
	}
}