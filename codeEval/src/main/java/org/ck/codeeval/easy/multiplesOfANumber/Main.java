package org.ck.codeeval.easy.multiplesOfANumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 18, name = "Multiples of a Number", description = "Multiples of a number greater than another number.", url = "https://www.codeeval.com/open_challenges/18/", category = "Easy challenges")
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
				String[] numbers = line.split(",");

				int threshold = Integer.parseInt(numbers[0]);
				int powerOf2 = Integer.parseInt(numbers[1]);
				int multiples = powerOf2;

				while (multiples < threshold)
				{
					multiples += powerOf2;
				}
				
				System.out.println(multiples);
			}
		}
	}
}
