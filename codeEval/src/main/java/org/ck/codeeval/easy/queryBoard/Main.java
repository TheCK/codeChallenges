package org.ck.codeeval.easy.queryBoard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 87, name = "Query Board", description = "Set and get values from a matrix using tiny DSL", url = "https://www.codeeval.com/open_challenges/87/", category = "Easy challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			byte[][] board = new byte[256][256];
			
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] values = line.split(" ");
				
				if ("SetCol".equals(values[0]))
				{
					int col = Integer.parseInt(values[1]);
					byte val = Byte.parseByte(values[2]);
					
					for (int i = 0; i < 256; ++i)
					{
						board[col][i] = val;
					}
				}
				else if ("SetRow".equals(values[0]))
				{
					int row = Integer.parseInt(values[1]);
					byte val = Byte.parseByte(values[2]);
					
					for (int i = 0; i < 256; ++i)
					{
						board[i][row] = val;
					}
				}
				else if ("QueryCol".equals(values[0]))
				{
					int col = Integer.parseInt(values[1]);
					int sum = 0;
					
					for (int i = 0; i < 256; ++i)
					{
						sum += board[col][i];
					}
					
					System.out.println(sum);
				}
				else if ("QueryRow".equals(values[0]))
				{
					int row = Integer.parseInt(values[1]);
					int sum = 0;
					
					for (int i = 0; i < 256; ++i)
					{
						sum += board[i][row];
					}
					
					System.out.println(sum);
				}
			}
		}
	}
}
