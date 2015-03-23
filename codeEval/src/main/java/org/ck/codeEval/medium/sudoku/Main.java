package org.ck.codeEval.medium.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 78, name = "Sudoku", description = "Determine if a grid layout is a valid sudoku solution.", url = "https://www.codeeval.com/open_challenges/78/", category = "Moderate callenges")
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

				Integer dimension = Integer.valueOf(arguments[0]);
				String[] array = arguments[1].split(",");

				Boolean valid = true;
				for (Integer i = 0; i < dimension; ++i)
				{
					Set<String> row = new HashSet<>();
					Set<String> column = new HashSet<>();
					
					for (Integer j = 0; j < dimension; ++j)
					{
						if (row.contains(array[i * dimension + j]))
						{
							valid = false;
							break;
						}
						if (column.contains(array[j * dimension + i]))
						{
							valid = false;
							break;
						}
						row.add(array[i * dimension + j]);
						column.add(array[j * dimension + i]);
					}
				}
				
				Integer dimensionSq = (int) Math.sqrt(dimension);
				
				for (Integer iBox = 0; iBox < dimensionSq; ++iBox)
				{
					for (Integer jBox = 0; jBox < dimensionSq; ++jBox)
					{
						Set<String> box = new HashSet<>();
						
						for (Integer i = 0; i < dimensionSq; ++i)
						{
							for (Integer j = 0; j < dimensionSq; ++j)
							{
								if (box.contains(array[(iBox * dimensionSq + i) * dimension + (jBox * dimensionSq + j)]))
								{
									valid = false;
									break;
								}
								box.add(array[(iBox * dimensionSq + i) * dimension + (jBox * dimensionSq + j)]);
							}
						}
					}	
				}
				
				System.out.println(valid ? "True" : "False");
			}
		}
	}
}