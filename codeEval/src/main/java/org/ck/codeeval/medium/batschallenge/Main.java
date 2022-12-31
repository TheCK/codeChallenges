package org.ck.codeeval.medium.batschallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 146, name = "Bats Challenge", description = "Count bats on the wire.", url = "https://www.codeeval.com/open_challenges/146/", category = "Moderate challenges")
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
				String[] values = line.split(" ");

				int length = Integer.parseInt(values[0]);
				int distance = Integer.parseInt(values[1]);
				int bats = Integer.parseInt(values[2]);

				boolean[] string = new boolean[length];

				for (int i = 0; i < bats; ++i)
				{
					string[Integer.parseInt(values[3 + i]) - 1] = true;
				}

				for (int i = 5; i < string.length - 6; ++i)
				{
					if (checkBefore(string, i, distance) && checkAfter(string, i, distance))
					{
						string[i] = true;
					}
				}

				int sum = 0;
				for (boolean position : string)
				{
					if (position)
					{
						++sum;
					}
				}

				System.out.println(sum - bats);
			}
		}
	}

	private static boolean checkBefore(boolean[] string, int position, int distance)
	{
		int start = position - distance + 1;
		if (start < 0)
		{
			start = 0;
		}

		for (int i = start; i < position; ++i)
		{
			if (string[i])
			{
				return false;
			}
		}

		return true;
	}

	private static boolean checkAfter(boolean[] string, int position, int distance)
	{
		int end = position + distance;
		if (end > string.length)
		{
			end = string.length;
		}

		for (int i = position; i < end; ++i)
		{
			if (string[i])
			{
				return false;
			}
		}

		return true;
	}
}