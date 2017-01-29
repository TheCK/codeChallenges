package org.ck.codeEval.easy.ageDistribution;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Solution(
		id = 152,
		name = "Age distribution",
		description = "Print out where the person is.",
		url = "https://www.codeeval.com/open_challenges/152/",
		category = "Easy challenges"
)
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
				Integer age = Integer.valueOf(line);

				if (0 <= age && age <= 2)
				{
					System.out.println("Still in Mama's arms");
				}
				else if (3 <= age && age <= 4)
				{
					System.out.println("Preschool Maniac");
				}
				else if (5 <= age && age <= 11)
				{
					System.out.println("Elementary school");
				}
				else if (12 <= age && age <= 14)
				{
					System.out.println("Middle school");
				}
				else if (15 <= age && age <= 18)
				{
					System.out.println("High school");
				}
				else if (19 <= age && age <= 22)
				{
					System.out.println("College");
				}
				else if (23 <= age && age <= 65)
				{
					System.out.println("Working for the man");
				}
				else if (66 <= age && age <= 100)
				{
					System.out.println("The Golden Years");
				}
				else
				{
					System.out.println("This program is for humans");
				}
			}
		}
	}
}