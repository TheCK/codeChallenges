package org.ck.codeeval.easy.armstrongnumbers;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(
		id = 82,
		name = "Armstrong Numbers",
		description = "Determine if a number is an armstrong number.",
		url = "https://www.codeeval.com/open_challenges/82/",
		category = "Easy challenges"
)
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

				Integer n = line.length();
				Integer a = 0;
				for (int i = 0; i < line.length(); ++i)
				{
					a += (int) Math.pow(Integer.valueOf(line.substring(i, i + 1)), n);
				}

				System.out.println(a.toString().equals(line) ? "True" : "False");
			}
		}
	}
}
