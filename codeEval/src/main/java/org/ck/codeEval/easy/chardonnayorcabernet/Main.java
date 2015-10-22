package org.ck.codeEval.easy.chardonnayorcabernet;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Solution(id = 211, name = "Chardonnay or Cabernet", description = "Guess a wine name.", url = "https://www.codeeval.com/open_challenges/211/", category = "Easy challenges")
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
				String[] arguments = line.split("\\|");

				List<String> wines = Arrays.asList(arguments[0].trim().split(" "));
				List<String> letters = Arrays.asList(arguments[1].trim().split(""));

				List<String> matchedWines = new ArrayList<>();
				for (String wine : wines)
				{
					Map<String, Integer> usedLetters = new HashMap<>();
					boolean wineMatches = true;

					for (String letter : letters)
					{
						if (!usedLetters.containsKey(letter))
						{
							if (!wine.contains(letter))
							{
								wineMatches = false;
								break;
							}

							usedLetters.put(letter, 1);
						}
						else
						{
							int count = usedLetters.get(letter) + 1;

							boolean containsLettersSeveralTimes = true;

							int lastIndex = -1;
							for (int i = 0; i < count; ++i)
							{
								int index = wine.indexOf(letter, lastIndex + 1);

								if (index != -1)
								{
									lastIndex = index;
								}
								else
								{
									containsLettersSeveralTimes = false;
									break;
								}
							}

							if (!containsLettersSeveralTimes)
							{
								wineMatches = false;
								break;
							}

							usedLetters.put(letter, count);
						}
					}

					if (wineMatches)
					{
						matchedWines.add(wine);
					}
				}

				StringBuilder builder = new StringBuilder();
				for (String match : matchedWines)
				{
					builder.append(match);
					builder.append(" ");
				}

				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				else
				{
					builder.append("False");
				}
				System.out.println(builder);
			}
		}
	}
}