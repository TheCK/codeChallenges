package org.ck.hackerRank.corecs.datastructures.arrays.arraysds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 20101,
		name = "Arrays - DS",
		url = "https://www.hackerrank.com/challenges/arrays-ds",
		category = "Data Structures",
		subCategory = "Arrays"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer length = in.nextInt();
			List<Integer> array = new ArrayList<>();

			for (Integer i = 0; i < length; ++i)
			{
				array.add(in.nextInt());
			}

			Collections.reverse(array);

			System.out.println(array.stream()
					.map(number -> number.toString())
					.collect(Collectors.joining(" "))
			);
		}
	}
}