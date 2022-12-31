package org.ck.codeeval.easy.matrixRotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 179, name = "Matrix Rotation", description = "Rotate a 2D matrix 90 degrees clockwise.", url = "https://www.codeeval.com/open_challenges/179/", category = "Easy challenges")
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
				String[] matrix = line.split(" ");

				Integer n = (int) Math.sqrt(matrix.length);

				StringBuilder builder = new StringBuilder();
				for (Integer j = 0; j < n; ++j)
				{
					for (Integer i = n - 1; i >= 0; --i)
					{
						builder.append(matrix[n * i + j] + " ");
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
}
