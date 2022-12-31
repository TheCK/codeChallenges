package org.ck.codeeval.medium.jollyJumpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 43, name = "Jolly Jumpers", description = "Determine if a sequence of numbers is a Jolly Jumper", url = "https://www.codeeval.com/open_challenges/43/", category = "Moderate challenges")
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
				
				numbers = Arrays.copyOfRange(numbers, 1, numbers.length);

				Set<Integer> diffs = new HashSet<>();

				if (numbers.length > 1)
				{
					for (int i = 1; i < numbers.length; ++i)
					{
						Integer a = Integer.valueOf(numbers[i - 1]);
						Integer b = Integer.valueOf(numbers[i]);

						Integer diff = 0;
						if (a > b)
						{
							diff = a - b;
						}
						else
						{
							diff = b - a;
						}
						
						if (diffs.contains(diff) || diff > numbers.length - 1 || diff == 0)
						{
							System.out.println("Not jolly");
							break;
						}
						diffs.add(diff);
					}
					
					if(diffs.size() + 1 == numbers.length)
					{
						System.out.println("Jolly");
					}
				}
				else
				{
					System.out.println("Jolly");
				}
			}
		}
	}
}