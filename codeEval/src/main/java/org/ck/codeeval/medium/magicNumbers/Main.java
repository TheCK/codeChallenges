package org.ck.codeeval.medium.magicNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 193, name = "Magic Numbers", description = "Print out a list of all the magic numbers in a provided range.", url = "https://www.codeeval.com/open_challenges/193/", category = "Moderate challenges")
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
				String[] numbers = line.split(" ");
				
				int start = Integer.parseInt(numbers[0]);
				int end = Integer.parseInt(numbers[1]);
				
				StringBuilder builder = new StringBuilder();
				
				for (int i = start; i <= end; ++i)
				{
					char[] digits = String.valueOf(i).toCharArray();
					
					Set<Character> usedDigits = new HashSet<>();
					for (char digit : digits)
					{
						usedDigits.add(digit);
					}
					
					if (usedDigits.size() != digits.length)
					{
						continue;
					}
					
					Set<Integer> usedIndeces = new HashSet<>();
					int index = 0;
					
					for (int j = 0; j < digits.length; ++j)
					{
						if (usedIndeces.contains(index))
						{
							break;
						}
						
						usedIndeces.add(index);
						index = (index + Integer.parseInt(String.valueOf(digits[index]))) % digits.length;
					}
					
					if (usedIndeces.size() != digits.length || index != 0)
					{
						continue;
					}
					
					builder.append(i + " ");
				}
				
				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				else
				{
					builder.append("-1");
				}
				
				System.out.println(builder);
			}
		}
	}
}