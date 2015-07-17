package org.ck.codeEval.medium.consecutivePrimes;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
				int max = Integer.parseInt(line);

				List<Integer> numbers = new ArrayList<>();

				for(int i = 1; i <= max; ++i)
				{
					numbers.add(i);
				}

				List<List<Integer>> necklaces = new ArrayList<>();
				getPermutations(necklaces, numbers, new ArrayList<Integer>());

				int count = 0;
				for (List<Integer> necklace : necklaces)
				{
					boolean matches = true;

					for(int i = 0; i < necklace.size(); ++i)
					{
						int first = necklace.get(i);
						int second = necklace.get((i + 1) % necklace.size());

						if (!isPrime(first + second))
						{
							matches = false;
							break;
						}
					}

					if (matches)
					{
						++count;
					}
				}

				System.out.println(count / max);
			}
		}
	}

	private static boolean isPrime(int candidate)
	{
		boolean isPrime = true;

		for (int i = 2; i <= Math.sqrt(candidate); ++i)
		{
			if (candidate % i == 0)
			{
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	private static void getPermutations(List<List<Integer>> permutations, List<Integer> remainingNumbers, List<Integer> current)
	{
		for (Integer number : remainingNumbers)
		{
			List<Integer> copyOfRemainingNumbers = new ArrayList<>(remainingNumbers);
			copyOfRemainingNumbers.remove(number);

			List<Integer> copyOfCurrent = new ArrayList<>(current);
			copyOfCurrent.add(number);

			if (copyOfRemainingNumbers.size() == 0)
			{
				permutations.add(copyOfCurrent);
			}
			else
			{
				getPermutations(permutations, copyOfRemainingNumbers, copyOfCurrent);
			}
		}
	}
}