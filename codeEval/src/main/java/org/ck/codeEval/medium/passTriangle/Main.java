package org.ck.codeEval.medium.passTriangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 89, name = "Pass Triangle", description = "Lead the way within the triangle", url = "https://www.codeeval.com/open_challenges/89/", category = "Moderate callenges")
public class Main
{
	private static int[][] sumSoFar = null;
	
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			List<List<Short>> triangle = new ArrayList<>();
			
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] stringRow = line.split(" ");
				
				List<Short> row = new ArrayList<>();
				
				for (String element : stringRow)
				{
					row.add(Short.valueOf(element));
				}
				
				triangle.add(row);
			}
			
			sumSoFar = new int[triangle.size() + 1][triangle.size() + 1];
			
			int sum = findSum(triangle, triangle.size(), 0, 0);
			
			System.out.println(sum);
		}
	}

	private static int findSum(List<List<Short>> triangle, int max, int row, int column)
	{
		int sum = 0;
		
		if (sumSoFar[row][column] != 0)
		{
			return sumSoFar[row][column];
		}
			
		if (row < max)
		{
			int leftSum = findSum(triangle, max, row + 1, column);
			int rightSum = findSum(triangle, max, row + 1, column + 1);
			
			sum = Math.max(rightSum, leftSum) + triangle.get(row).get(column);
			sumSoFar[row][column] = sum;
		}
		
		return sum;
	}
}