package org.ck.codeEval.medium.cityBlocksFlyover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 133, name = "City Blocks Flyover", description = "Chart the path of a helicopter from above to discover how many city blocks it flew over.", url = "https://www.codeeval.com/open_challenges/133/", category = "Moderate challenges")
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
				String[] array = line.split("\\) \\(");
				
				String[] streetStrings = array[0].substring(1).split(",");
				String[] avenueStrings = array[1].substring(0, array[1].length() - 1).split(",");
				
				int[] streets = new int[streetStrings.length];
				int[] avenues = new int[avenueStrings.length];
				
				for (int i = 0; i < streetStrings.length; ++i)
				{
					streets[i] = Integer.parseInt(streetStrings[i]);
				}
				for (int i = 0; i < avenueStrings.length; ++i)
				{
					avenues[i] = Integer.parseInt(avenueStrings[i]);
				}
				
				double slope = ((double) avenues[avenues.length - 1]) / streets[streets.length - 1];
				
				int count = 0;
				int lastAvenue = 1;
				
				for (int i = 1; i < streetStrings.length; ++i)
				{
					int x = streets[i];
					
					double y = slope * x;
					
					for (int j = lastAvenue; j < avenues.length; ++j)
					{
						int avenueY = avenues[j];
						
						++count;
						if (avenueY == y)
						{
							lastAvenue = j + 1;
							break;
						}
						if (avenueY > y)
						{
							lastAvenue = j;
							break;
						}
					}
				}
				
				System.out.println(count);
			}
		}
	}
}