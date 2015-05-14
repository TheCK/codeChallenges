package org.ck.codeEval.medium.sumOfIntegers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 17, name = "Sum of integers", description = "Determine the largest sum of contiguous integers in an array.", url = "https://www.codeeval.com/open_challenges/17/", category = "Moderate challenges")
public class Main
{
	private static Map<List<Integer>, Integer> sums = new HashMap<>();
	
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] strings = line.split(",");

				List<Integer> numbers = new ArrayList<>();
				for (String string : strings)
				{
					numbers.add(Integer.valueOf(string));
				}

				Integer sum = sum(numbers);
				System.out.println(sum);
			}
		}
	}

	private static Integer sum(List<Integer> numbers)
	{
		Integer sum = 0;
		for (Integer number : numbers)
		{
			sum += number;
		}

		if (numbers.size() > 1)
		{
			List<Integer> leftSumArray = new ArrayList<>(numbers);
			leftSumArray.remove(numbers.size() - 1);
			
			Integer leftSum = 0;
			if (sums.containsKey(leftSumArray))
			{
				leftSum = sums.get(leftSumArray);
			}
			else
			{
				leftSum = sum(leftSumArray);
				sums.put(leftSumArray, leftSum);
			}

			if (leftSum > sum)
			{
				sum = leftSum;
			}

			List<Integer> rightSumArray = new ArrayList<>(numbers);
			rightSumArray.remove(0);
			
			Integer rightSum = 0;
			if (sums.containsKey(rightSumArray))
			{
				rightSum = sums.get(rightSumArray);
			}
			else
			{
				rightSum = sum(rightSumArray);
				sums.put(rightSumArray, rightSum);
			}

			if (rightSum > sum)
			{
				sum = rightSum;
			}
		}

		return sum;
	}
}