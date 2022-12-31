package org.ck.codeeval.hard.minesweeper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 79, name = "Minesweeper", description = "Find the mines within a M*N matrix.", url = "https://www.codeeval.com/open_challenges/79/", category = "Hard challenges")
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
				String[] arguments = line.split(";");
				String[] sizes = arguments[0].split(",");
				
				boolean[][] field = new boolean[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
				int[][] output = new int[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
				
				int count = 0;
				for (int row = 0; row < field.length; ++row)
				{
					for (int column = 0; column < field[0].length; ++column)
					{
						field[row][column] = arguments[1].substring(count, count + 1).equals("*");
						++count;
					}
				}
				
				for (int row = 0; row < field.length; ++row)
				{
					for (int column = 0; column < field[0].length; ++column)
					{
						output[row][column] = count(field, row, column);
					}
				}
				
				printField(output);
			}
		}
	}
	
	private static int count(boolean[][] field, int row, int column)
	{
		if (field[row][column])
		{
			return 9;
		}
		
		int count = 0;
		
		if (row > 0 && column > 0 && field[row - 1][column - 1])
		{
			++count;
		}
		if (row > 0 && field[row - 1][column])
		{
			++count;
		}
		if (row > 0 && column < field[0].length - 1 && field[row - 1][column + 1])
		{
			++count;
		}
		if (column > 0 && field[row][column - 1])
		{
			++count;
		}
		if (column < field[0].length - 1 && field[row][column + 1])
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
		if (row < field.length - 1 && column < field[0].length - 1 && field[row + 1][column + 1])
		{
			++count;
		}
		
		return count;
	}
	
	private static void printField(int[][] field)
	{
		for (int[] line : field)
		{
			for (int box : line)
			{
				if (box != 9)
				{
					System.out.print(box);
				}
				else
				{
					System.out.print("*");
				}
			}
		}
		
		System.out.println("");
	}
}