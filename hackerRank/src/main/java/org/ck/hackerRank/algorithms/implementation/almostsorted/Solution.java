package org.ck.hackerRank.algorithms.implementation.almostsorted;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10243,
		name = "Almost Sorted",
		url = "https://www.hackerrank.com/challenges/almost-sorted",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int length = in.nextInt();

			int[] array = new int[length];
			for (int i = 0; i < length; ++i)
			{
				array[i] = in.nextInt();
			}

			if (isSorted(array))
			{
				System.out.println("yes");
			}
			else
			{
				Optional<Pair<Integer, Integer>> swapPoints = checkForFixBySwap(Arrays.copyOf(array, length));

				if (swapPoints.isPresent())
				{
					System.out.println("yes");
					System.out.println(String.format("swap %d %d", swapPoints.get().getKey(), swapPoints.get().getValue()));
				}
				else
				{
					Optional<Pair<Integer, Integer>> reversePoints = checkForFixByReverse(Arrays.copyOf(array, length));

					if (reversePoints.isPresent())
					{
						System.out.println("yes");
						System.out.println(String.format("reverse %d %d", reversePoints.get().getKey(), reversePoints.get().getValue()));
					}
					else
					{
						System.out.println("no");
					}
				}
			}
		}
	}

	private static Optional<Pair<Integer, Integer>> checkForFixByReverse(int[] array)
	{
		int potentialFirstIndex = -1;
		int potentialSecondIndex = -1;

		for (int i = 0; i < array.length - 1; ++i)
		{
			if (array[i] >= array[i + 1] && potentialFirstIndex < 0)
			{
				potentialFirstIndex = i;
			}
			else if (potentialFirstIndex >= 0 && potentialSecondIndex < 0 && array[i] <= array[i + 1])
			{
				potentialSecondIndex = i;
			}
		}

		if (potentialSecondIndex < 0)
		{
			potentialSecondIndex = array.length - 1;
		}

		if (potentialFirstIndex >= 0 && potentialSecondIndex >= 0)
		{
			int firstIndex = potentialFirstIndex;
			int secondIndex = potentialSecondIndex;

			while (firstIndex < secondIndex)
			{
				array = swapElements(array, firstIndex, secondIndex);

				++firstIndex;
				--secondIndex;
			}

			if (isSorted(array))
			{
				return Optional.of(new Pair<>(potentialFirstIndex + 1, potentialSecondIndex + 1));
			}
		}

		return Optional.empty();
	}

	private static Optional<Pair<Integer, Integer>> checkForFixBySwap(int[] array)
	{
		int potentialFirstIndex = -1;
		int potentialSecondIndex = -1;

		for (int i = 0; i < array.length - 1; ++i)
		{
			if (array[i] >= array[i + 1])
			{
				if (potentialFirstIndex < 0)
				{
					System.err.println("1:" + i);
					potentialFirstIndex = i;
				}
				else if (potentialSecondIndex < 0)
				{
					System.err.println("2:" + i + 1);
					potentialSecondIndex = i + 1;
				}
			}
		}

		if (potentialSecondIndex < 0)
		{
			potentialSecondIndex = array.length - 1;
		}

		if (potentialFirstIndex >= 0 && potentialSecondIndex >= 0)
		{
			array = swapElements(array, potentialFirstIndex, potentialSecondIndex);

			if (isSorted(array))
			{
				return Optional.of(new Pair<>(potentialFirstIndex + 1, potentialSecondIndex + 1));
			}

			array = swapElements(array, potentialFirstIndex, potentialSecondIndex);
			if (potentialFirstIndex < array.length - 2)
			{
				potentialSecondIndex = potentialFirstIndex + 1;
			}

			array = swapElements(array, potentialFirstIndex, potentialSecondIndex);

			if (isSorted(array))
			{
				return Optional.of(new Pair<>(potentialFirstIndex + 1, potentialSecondIndex + 1));
			}
		}

		return Optional.empty();
	}

	private static boolean isSorted(int[] array)
	{
		boolean sorted = true;

		for (int i = 0; i < array.length - 1; ++i)
		{
			if (array[i] >= array[i + 1])
			{
				sorted = false;
				break;
			}
		}

		return sorted;
	}

	private static int[] swapElements(int[] array, int firstIndex, int secondIndex)
	{
		int tmp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = tmp;

		return array;
	}
}