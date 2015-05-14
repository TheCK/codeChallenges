package org.ck.codeEval.medium.burrowsWheelerTransform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 184, name = "Burrows-Wheeler transform", description = "Complete file decompression by inverting BWT.", url = "https://www.codeeval.com/open_challenges/184/", category = "Moderate challenges")
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
				line = line.replace("|", "");
				System.err.println(line);

				List<String> matrix = new ArrayList<>();
				for (int i = 0; i < line.length(); ++i)
				{
					matrix.add("");
				}

				for (int i = 0; i < line.length(); ++i)
				{
					List<String> newMatrix = new ArrayList<>();
					
					for (int j = 0; j < line.length(); ++j)
					{
						newMatrix.add(line.substring(j, j + 1) + matrix.get(j));
					}

					matrix = newMatrix;
					Collections.sort(matrix);
				}

				for (String result : matrix)
				{
					if (result.endsWith("$"))
					{
						System.out.println(result);
						break;
					}
				}
			}
		}
	}
}