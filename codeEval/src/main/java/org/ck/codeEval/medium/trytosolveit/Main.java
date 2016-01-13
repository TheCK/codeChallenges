package org.ck.codeEval.medium.trytosolveit;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 226, name = "Try to solve it", description = "How good decoder are you?", url = "https://www.codeeval.com/open_challenges/226/", category = "Moderate challenges")
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

				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < line.length(); ++i)
				{
					char letter = line.charAt(i);

					if (letter >= 'a' && letter <= 'f')
					{
						builder.append((char) (line.charAt(i) + 20));
					}
					else if (letter >= 'u' && letter <= 'z')
					{
						builder.append((char) (line.charAt(i) - 20));
					}
					else if (letter >= 'g' && letter <= 'm')
					{
						builder.append((char) (line.charAt(i) + 7));
					}
					else
					{
						builder.append((char) (line.charAt(i) - 7));
					}
				}

				System.out.println(builder);
			}
		}
	}
}