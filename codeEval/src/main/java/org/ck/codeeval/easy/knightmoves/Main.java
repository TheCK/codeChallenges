package org.ck.codeeval.easy.knightmoves;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 180, name = "Knight Moves", description = "Find positions for the next move of the knight.", url = "https://www.codeeval.com/open_challenges/180/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				ChessColumn colum = ChessColumn.valueOf(line.substring(0, 1));
				int row = Integer.parseInt(line.substring(1, 2));
				
				StringBuilder builder = new StringBuilder();
				
				if (colum.getValue() > 2)
				{
					if (row > 1)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() - 2).name() + String.valueOf(row - 1) + " ");
					}
					if (row < 8)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() - 2).name() + String.valueOf(row + 1) + " ");
					}
				}
				if (colum.getValue() > 1)
				{
					if (row > 2)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() - 1).name() + String.valueOf(row - 2) + " ");
					}
					if (row < 7)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() - 1).name() + String.valueOf(row + 2) + " ");
					}
				}
				if (colum.getValue() < 8)
				{
					if (row > 2)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() + 1).name() + String.valueOf(row - 2) + " ");
					}
					if (row < 7)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() + 1).name() + String.valueOf(row + 2) + " ");
					}
				}
				if (colum.getValue() < 7)
				{
					if (row > 1)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() + 2).name() + String.valueOf(row - 1) + " ");
					}
					if (row < 8)
					{
						builder.append(ChessColumn.getByInt(colum.getValue() + 2).name() + String.valueOf(row + 1) + " ");
					}
				}
				
				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				System.out.println(builder);
			}
		}
	}
	
	private enum ChessColumn
	{
		a(1), b(2), c(3), d(4), e(5), f(6), g(7), h(8);
		
		private int value;
		
		private ChessColumn(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return this.value;
		}
		
		public static ChessColumn getByInt(int value)
		{
			for (ChessColumn prospect : values())
			{
				if (prospect.getValue() == value)
				{
					return prospect;
				}
			}
			
			return null;
		}
	}
}
