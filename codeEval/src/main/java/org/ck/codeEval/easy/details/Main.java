package org.ck.codeEval.easy.details;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 183, name = "Details", description = "Determine how many cells will be shifted detail.", url = "https://www.codeeval.com/open_challenges/183/", category = "Easy challenges")
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
				String[] rows = line.split(",");

				int minimumDots = Integer.MAX_VALUE;

				for (String row : rows)
				{
					if (row.contains("."))
					{
						int dots = row.indexOf("Y") - row.lastIndexOf("X") - 1;

						if (dots < minimumDots)
						{
							minimumDots = dots;
						}
					}
					else
					{
						minimumDots = 0;
					}
				}

				System.out.println(minimumDots);
			}
		}
	}
}