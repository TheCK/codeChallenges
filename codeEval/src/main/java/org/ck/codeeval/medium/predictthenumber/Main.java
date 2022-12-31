package org.ck.codeeval.medium.predictthenumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 125, name = "Predict the Number", description = "Try to go beyond the limits", url = "https://www.codeeval.com/open_challenges/125/", category = "Moderate challenges")
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
				long position = Long.parseLong(line);

				int depth = 0;

				if (position > 0)
				{
					depth = getLog(position);
				}
				String solution = getFor(position, depth);

				System.out.println(solution);
			}
		}
	}

	private static int getLog(long position)
	{
		long number = position;
		int log = 0;

		while (number != 0)
		{
			number = number >> 1;
			++log;
		}

		return log;
	}

	private static String getFor(long position, int depth)
	{
		if (depth == 0)
		{
			return "0";
		}

		String fromBefore = getFor(position / 2, depth - 1);

		String fromHere = "";

		if (fromBefore.equals("0"))
		{
			fromHere = "01";
		}
		else if (fromBefore.equals("1"))
		{
			fromHere = "12";
		}
		else if (fromBefore.equals("2"))
		{
			fromHere = "20";
		}

		if (position % 2 == 0)
		{
			return fromHere.substring(0, 1);
		}

		return fromHere.substring(1, 2);
	}
}