package org.ck.codeeval.hard.minimumPathSum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 72, name = "Minimum Path Sum", description = "Calculate the minimum sum of a path through a matrix.", url = "https://www.codeeval.com/open_challenges/72/", category = "Hard challenges")
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
				int n = Integer.parseInt(line);

				int[][] matrix = new int[n][n];
				for (int i = 0; i < n; ++i)
				{
					line = buffer.readLine().trim();
					String[] numbers = line.split(",");
					
					for (int j = 0; j < n; ++j)
					{
						matrix[i][j] = Integer.parseInt(numbers[j]);
					}
				}
				
				int minSum = getMinSum(matrix, n, 0, 0);
				
				System.out.println(minSum);
			}
		}
	}

	private static int getMinSum(int[][] matrix, int n, int i, int j)
	{
		if (i == n - 1 && j == n - 1)
		{
			return matrix[i][j];
		}
		
		int downSum = Integer.MAX_VALUE;
		int rightSum = Integer.MAX_VALUE;
		
		if (i < n - 1)
		{
			downSum = getMinSum(matrix, n, i + 1, j);
		}
		if (j < n - 1)
		{
			rightSum = getMinSum(matrix, n, i, j + 1);
		}
		
		return Math.min(downSum, rightSum) + matrix[i][j];
	}
}