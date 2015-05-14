package org.ck.codeEval.medium.consecutivePrimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 187, name = "Consecutive Primes", description = "Determine how many ways the numbers can be arranged such that every consecutive pair sums to a prime.", url = "https://www.codeeval.com/open_challenges/187/", category = "Moderate challenges", solved = false)
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
			}
		}
	}
}