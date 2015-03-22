package org.ck.codeEval.easy.nModM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 62, name = "N Mod M", description = "Determine the modulus (without the modulus operator).", url = "https://www.codeeval.com/open_challenges/62/", category = "Easy callenges")
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

				Integer n = Integer.parseInt(numbers[0]);
				Integer m = Integer.parseInt(numbers[1]);

				System.out.println(n - ((n / m) * m));
			}
		}
	}
}
