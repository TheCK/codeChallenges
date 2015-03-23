package org.ck.codeEval.medium.sumToZero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 81, name = "Sum to Zero", description = "Count of ways in which the sum of four numbers is zero", url = "https://www.codeeval.com/open_challenges/81/", category = "Moderate callenges")
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
				String[] arguments = line.split(",");

				Integer count = 0;
				for (Integer i = 0; i < arguments.length - 3; ++i)
				{
					Integer number1 = Integer.valueOf(arguments[i]);
					
					for (Integer j = i + 1; j < arguments.length - 2; ++j)
					{
						Integer number2 = Integer.valueOf(arguments[j]);
						
						for (Integer k = j + 1; k < arguments.length - 1; ++k)
						{
							Integer number3 = Integer.valueOf(arguments[k]);
							
							for (Integer l = k + 1; l < arguments.length; ++l)
							{
								Integer number4 = Integer.valueOf(arguments[l]);
								
								if (number1 + number2 + number3 + number4 == 0)
								{
									++count;
								}
							}
						}
					}
				}
				
				System.out.println(count);
			}
		}
	}
}