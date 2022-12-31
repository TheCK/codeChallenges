package org.ck.codeeval.easy.notsoclever;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Solution(id = 232, name = "Not so clever", description = "Simplicity is not always good.", url = "https://www.codeeval.com/open_challenges/232/", category = "Easy challenges")
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
				String[] argumentList = line.split("\\|");

				String[] array = argumentList[0].trim().split(" ");
				Integer numberOfIterations = Integer.valueOf(argumentList[1].trim());

				for (int i = 0; i < numberOfIterations; ++i)
				{
					for (int j = 0; j < array.length - 2; ++j)
					{
						if (Integer.valueOf(array[j]) > Integer.valueOf(array[j + 1]))
						{
							String temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;

							break;
						}
					}
				}

				System.out.println(Arrays.stream(array).collect(Collectors.joining(" ")));
			}
		}
	}
}