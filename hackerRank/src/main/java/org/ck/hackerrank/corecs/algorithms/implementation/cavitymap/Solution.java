package org.ck.hackerrank.corecs.algorithms.implementation.cavitymap;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10249,
		name = "Cavity Map",
		url = "https://www.hackerrank.com/challenges/cavity-map",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();
			in.nextLine();

			int[][] array = new int[n][n];
			for (int i = 0; i < n; ++i)
			{
				String line = in.nextLine();

				for (int j = 0; j < n; ++j)
				{
					array[i][j] = line.charAt(j) - '0';
				}
			}

			for (int i = 0; i < n; ++i)
			{
				for (int j = 0; j < n; ++j)
				{
					if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
					{
						System.out.print(array[i][j]);
					}
					else if (array[i][j] > array[i - 1][j]
							&& array[i][j] > array[i + 1][j]
							&& array[i][j] > array[i][j - 1]
							&& array[i][j] > array[i][j + 1])
					{
						System.out.print("X");
					}
					else
					{
						System.out.print(array[i][j]);
					}
				}

				System.out.println();
			}
		}
	}
}