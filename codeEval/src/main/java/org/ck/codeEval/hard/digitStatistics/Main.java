package org.ck.codeEval.hard.digitStatistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 144, name = "Digit statistics", description = "Find statistics in sequence", url = "https://www.codeeval.com/open_challenges/144/", category = "Hard challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			Map<Integer, List<Integer>> lastDigits = new HashMap<>();
			lastDigits.put(2, Arrays.asList(new Integer[] {2, 4, 8, 6}));
			lastDigits.put(3, Arrays.asList(new Integer[] {3, 9, 7, 1}));
			lastDigits.put(4, Arrays.asList(new Integer[] {4, 6}));
			lastDigits.put(5, Arrays.asList(new Integer[] {5}));
			lastDigits.put(6, Arrays.asList(new Integer[] {6}));
			lastDigits.put(7, Arrays.asList(new Integer[] {7, 9, 3, 1}));
			lastDigits.put(8, Arrays.asList(new Integer[] {8, 4, 2, 6}));
			lastDigits.put(9, Arrays.asList(new Integer[] {9, 1}));
			
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] arguments = line.split(" ");
				Integer base = Integer.valueOf(arguments[0]);
				long exp = Long.parseLong(arguments[1]);
				
				List<Integer> endings = lastDigits.get(base);
				
				StringBuilder builder = new StringBuilder();
				for (Integer i = 0; i < 10; ++i)
				{
					long count = 0;
					if (endings.contains(i))
					{
						count += exp / endings.size();
						
						int remainder = (int) (exp % endings.size());
						if (remainder - 1 >= endings.indexOf(i))
						{
							++count;
						}
					}
					
					builder.append(i + ": " + count + ", ");
				}
				
				builder.deleteCharAt(builder.length() - 1);
				builder.deleteCharAt(builder.length() - 1);
				System.out.println(builder);
			}
		}
	}
}