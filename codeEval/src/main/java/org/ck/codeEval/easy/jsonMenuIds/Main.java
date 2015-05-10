package org.ck.codeEval.easy.jsonMenuIds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 102, name = "JSON menu IDs", description = "Calculate IDs in JSON menu", url = "https://www.codeeval.com/open_challenges/102/", category = "Easy challenges")
public class Main
{
	private static Pattern pattern = Pattern.compile("\\{.*?\\}");
	private static Pattern patternForId = Pattern.compile("\\\"id\\\": (\\d+)");
	
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();

				if (line.length() > 0)
				{
					Matcher matcher = pattern.matcher(line);
					Integer sum = 0;
					
					while (matcher.find())
					{
						String current = matcher.group();
						
						if (current.contains("id") && current.contains("label"))
						{
							Matcher matcherForId = patternForId.matcher(current);
							
							while (matcherForId.find())
							{
								String[] values = matcherForId.group().split(" ");
								
								sum += Integer.valueOf(values[1]);
							}
						}
					}
					
					System.out.println(sum);
				}
			}
		}
	}
}