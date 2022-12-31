package org.ck.codeeval.easy.maxRangeSum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 186, name = "Max Range Sum", description = "Determine max sum at the range.", url = "https://www.codeeval.com/open_challenges/186/", category = "Easy challenges")
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
				String[] arguments = line.split(";");

				int length = Integer.parseInt(arguments[0]);
				String[] array = arguments[1].split(" ");
				
				int[] ints = new int[array.length];
				for (int i = 0; i < array.length; ++i)
				{
					ints[i] = Integer.parseInt(array[i]);
				}
				
				int maxSum = 0;
				
				for(int i = 0; i < (ints.length - length + 1); ++i)
				{
					int sum = 0;
					
					for (int j = i; j < i + length; ++j)
					{
						sum += ints[j];
					}
					
					maxSum = Math.max(sum, maxSum);
				}
				
				System.out.println(maxSum);
			}
		}
	}
}