package org.ck.codeeval.medium.pascalstriangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 66, name = "Pascals Triangle", description = "Print out pascals triangle upto a certain depth.", url = "https://www.codeeval.com/open_challenges/66/", category = "Moderate challenges")
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
				int max = Integer.parseInt(line);
				
				Integer[][] triangle = new Integer[max][max];
				triangle[0][0] = 1;
				
				for (int i = 1; i < max; ++i)
				{
					for (int j = 0; j <= i; ++j)
					{
						if (j == 0 || j == i)
						{
							triangle[i][j] = 1;
						}
						else
						{
							triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
						}
					}
				}
				
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < max; ++i)
				{
					for (int j = 0; j < max; ++j)
					{
						if (triangle[i][j] == null)
						{
							break;
						}
						
						builder.append(triangle[i][j] + " ");
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