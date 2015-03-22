package org.ck.codeEval.hard.spiralPrinting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 57, name = "Spiral Printing", description = "Print out a 2D array in spiral order", url = "https://www.codeeval.com/open_challenges/57/", category = "Hard callenges")
public class Main
{
	private static final int LEFT = 1;
	private static final int DOWN = 2;
	private static final int RIGHT = 3;
	private static final int UP = 4;
	
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
				String[] array = arguments[2].split(" ");

				String[][] field = new String[Integer.parseInt(arguments[0])][Integer.parseInt(arguments[1])];

				int count = 0;
				for (int row = 0; row < field.length; ++row)
				{
					for (int column = 0; column < field[0].length; ++column)
					{
						field[row][column] = array[count++];
					}
				}

				printField(field);
			}
		}
	}

	private static void printField(String[][] field)
	{
		StringBuilder builder = new StringBuilder();
		
		int rowNumber = field.length;
		int colNumber = field[0].length;
		
		int row = 0;
		int column = 0;
		int direction = LEFT;
		for(int i = 0; i < field.length * field[0].length; ++i)
		{
			builder.append(field[row][column] + " ");
			
			if (direction == LEFT)
			{
				column++;
				
				if (column == colNumber - row)
				{
					direction = DOWN;
					column--;
					row++;
				}
			}
			else if (direction == DOWN)
			{
				row++;
				
				if (row == rowNumber - (colNumber - column - 1))
				{
					direction = RIGHT;
					column--;
					row--;
				}
			}
			else if (direction == RIGHT)
			{
				column--;
				
				if (column == field.length - row - 2)
				{
					direction = UP;
					column++;
					row--;
				}
			}
			else if (direction == UP)
			{
				row--;
				
				if (row == column)
				{
					direction = LEFT;
					row++;
					column++;
				}
			}
		}

		if (builder.length() > 0)
		{
			builder.deleteCharAt(builder.length() - 1);
		}
		System.out.println(builder);
	}
}