package org.ck.hackerRank.algorithms.arraysAndSorting.insertionSortPart1;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(id = 10302, name = "Insertion Sort - Part 1", url = "https://www.hackerrank.com/challenges/insertionsort1", category = "Algorithms", subCategory = "Sorting")
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int size = in.nextInt();

			int[] array = new int[size];
			for (int i = 0; i < size; ++i)
			{
				array[i] = in.nextInt();
			}
			
			boolean inserted = false;
			
			int number = array[size - 1];
			for (int i = size - 2; i >= 0; --i)
			{
				System.err.println(inserted);
				if (array[i] > number)
				{
					array[i + 1] = array[i];
					
					printArray(array);
				}
				else
				{
					array[i + 1] = number;
					
					printArray(array);
					
					inserted = true;
					break;
				}
			}
			
			if (!inserted)
			{
				array[0] = number;
				
				printArray(array);
			}
		}
	}

	private static void printArray(int[] array)
	{
		StringBuilder builder = new StringBuilder();

		for (int number : array)
		{
			builder.append(number + " ");
		}
		
		builder.deleteCharAt(builder.length() - 1);
		System.out.println(builder);
	}
}