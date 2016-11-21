package org.ck.codeEval.medium.meetcombsort;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 233, name = "Meet Comb sort", description = "Learn more about the comb sort algorithm.", url = "https://www.codeeval.com/open_challenges/233/", category = "Moderate challenges")
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
				String[] array = line.split(" ");

				int iterations = 0;
				int step = array.length;
				boolean sorted = false;

				while (!sorted)
				{
					step = (int) (step / 1.25d);

					if (step == 0)
					{
						step = 1;
						sorted = true;
					}

					for (int first = 0; first < array.length - step; ++first)
					{
						int last = first + step;

						if (Integer.parseInt(array[first]) > Integer.parseInt(array[last]))
						{
							String temp = array[first];
							array[first] = array[last];
							array[last] = temp;

							sorted = false;
						}
					}

					++iterations;
					if (isSorted(array))
					{
						sorted = true;
					}
				}

				System.out.println(iterations);
			}
		}
	}

	private static boolean isSorted(String[] array)
	{
		boolean sorted = true;

		for (int i = 0; i < array.length - 1; ++i)
		{
			if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1]))
			{
				sorted = false;
				break;
			}
		}

		return sorted;
	}
}