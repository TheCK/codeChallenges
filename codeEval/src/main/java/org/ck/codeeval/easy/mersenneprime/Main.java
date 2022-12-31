package org.ck.codeeval.easy.mersenneprime;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Solution(id = 240, name = "Mersenne prime", description = "Find all Mersenne numbers smaller than n.", url = "https://www.codeeval.com/open_challenges/240/", category = "Easy challenges")
public class Main
{
	private static List<Integer> mersenneNumbers;

	private static void initMersenneNumbers()
	{
		mersenneNumbers = new ArrayList<>();

		for (int i = 2; i <= 13; ++i)
		{
			if (isPrime(i))
			{
				int power = (int) Math.pow(2, i);
				int mersenneNumber = power - 1;

				mersenneNumbers.add(mersenneNumber);
			}
		}
	}

	private static boolean isPrime(int candidate)
	{
		for (int i = 2; i <= Math.sqrt(candidate); ++i)
		{
			if (candidate % i == 0)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException
	{
		initMersenneNumbers();

		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				Integer upperBoundary = Integer.valueOf(line);

				String concatanatedNumbers = mersenneNumbers.stream()
					.filter(mersenneNumber -> mersenneNumber < upperBoundary)
					.map(String::valueOf)
					.collect(Collectors.joining(", "));

				System.out.println(concatanatedNumbers);
			}
		}
	}
}