package org.ck.codeEval.medium.interruptedBubbleSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 158, name = "Interrupted Bubble Sort", description = "Sort a list of elements. Partially.", url = "https://www.codeeval.com/open_challenges/158/", category = "Moderate callenges")
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
				String[] arguments = line.split("\\|");

				String[] stringArray = arguments[0].trim().split(" ");
				long rounds = Long.parseLong(arguments[1].trim());
				
				int[] array = new int[stringArray.length];
				for (int i = 0; i < stringArray.length; ++i)
				{
					array[i] = Integer.parseInt(stringArray[i]);
				}
				
				while (rounds != 0)
				{
					boolean isSorted = true;
					
					for (int i = 1; i < array.length; ++i)
					{
						if (array[i - 1] > array[i])
						{
							int temp = array[i - 1];
							array[i - 1] = array[i];
							array[i] = temp;
							
							isSorted = false;
						}
					}
					
					if (isSorted)
					{
						break;
					}
					
					--rounds;
				}
				
				StringBuilder builder = new StringBuilder();
				for(int element : array)
				{
					if (builder.length() > 0)
					{
						builder.append(" ");
					}
					
					builder.append(element);
				}
				System.out.println(builder);
			}
		}
	}
}