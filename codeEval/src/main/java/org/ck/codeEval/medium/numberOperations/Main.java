package org.ck.codeEval.medium.numberOperations;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Solution(id = 190, name = "Number Operations", description = "Determine if it is possible to produce the number 42 with five cards.", url = "https://www.codeeval.com/open_challenges/190/", category = "Moderate challenges")
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

				String[] numberTexts = line.split(" ");
				List<Integer> numbers = new ArrayList<>();

				for (String numberText : numberTexts)
				{
					numbers.add(Integer.valueOf(numberText));
				}

				List<List<Integer>> permutations = new ArrayList<>();
				getPermutations(permutations, numbers, new ArrayList<Integer>());

				boolean canReach42 = false;
				for (List<Integer> shuffled : permutations)
				{
					if(doMaths(shuffled.get(0), shuffled, 1))
					{
						canReach42 = true;
						break;
					}
				}

				System.out.println(canReach42 ? "YES" : "NO");
			}
		}
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

	private static boolean doMaths(Integer current, List<Integer> numbers, int offset)
	{
		if (offset == numbers.size())
		{
			return current.equals(42);
		}

		return doMaths(current + numbers.get(offset), numbers, offset + 1)
				|| doMaths(current - numbers.get(offset), numbers, offset + 1)
				|| doMaths(current * numbers.get(offset), numbers, offset + 1);
	}
}