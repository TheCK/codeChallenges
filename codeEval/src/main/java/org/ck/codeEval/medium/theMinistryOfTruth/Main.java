package org.ck.codeEval.medium.theMinistryOfTruth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 143, name = "The Ministry of Truth", description = "Your task is to help the Big Brother", url = "https://www.codeeval.com/open_challenges/143/", category = "Moderate challenges")
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
				String[] phrases = line.split(";");

				String[] original = phrases[0].replaceAll("\\s+", " ").split(" ");
				String[] wanted = new String[0];

				if (phrases.length > 1)
				{
					wanted = phrases[1].split(" ");
				}

				int originalPosition = 0;
				int wantedPosition = 0;

				StringBuilder builder = new StringBuilder();
				while (wantedPosition < wanted.length && originalPosition < original.length)
				{
					if (original[originalPosition].contains(wanted[wantedPosition]))
					{
						int start = original[originalPosition].indexOf(wanted[wantedPosition]);
						int end = start + wanted[wantedPosition].length();
						builder.append(underscores(start) + wanted[wantedPosition]
								+ underscores(original[originalPosition].length() - end) + " ");

						++wantedPosition;
					}
					else
					{
						builder.append(underscores(original[originalPosition].length()) + " ");
					}

					++originalPosition;
				}

				while (originalPosition < original.length)
				{
					builder.append(underscores(original[originalPosition].length()) + " ");
					++originalPosition;
				}

				if (wantedPosition != wanted.length)
				{
					System.out.println("I cannot fix history");
				}
				else
				{
					builder.deleteCharAt(builder.length() - 1);
					System.out.println(builder);
				}
			}
		}
	}

	private static String underscores(int length)
	{
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < length; ++i)
		{
			builder.append("_");
		}

		return builder.toString();
	}
}