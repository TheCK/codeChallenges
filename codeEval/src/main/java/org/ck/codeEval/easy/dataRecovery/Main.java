package org.ck.codeEval.easy.dataRecovery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 140, name = "Data Recovery", description = "Reconstruct a sentence using hints", url = "https://www.codeeval.com/open_challenges/140/", category = "Easy callenges")
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
				String[] input = line.split(";");
				
				List<String> words = Arrays.asList(input[0].split(" "));
				List<String> hints = Arrays.asList(input[1].split(" "));
				
				StringBuilder builder = new StringBuilder();
				for (Integer i = 1; i <= words.size(); ++i)
				{
					Integer index = hints.indexOf(String.valueOf(i));
					
					if (index == -1)
					{
						builder.append(words.get(words.size() - 1));
					}
					else
					{
						builder.append(words.get(index));
					}
					builder.append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				
				System.out.println(builder);
			}
		}
	}
}