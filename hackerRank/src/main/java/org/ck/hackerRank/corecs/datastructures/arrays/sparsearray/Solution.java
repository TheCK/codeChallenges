package org.ck.hackerRank.corecs.datastructures.arrays.sparsearray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 20105,
		name = "Sparse Array",
		url = "https://www.hackerrank.com/challenges/sparse-arrays",
		category = "Data Structures",
		subCategory = "Arrays"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer strings = in.nextInt();
			in.nextLine();

			Map<String, Integer> map = new HashMap<>();

			for (Integer i = 0; i < strings; ++i)
			{
				String string = in.next();

				map.put(string, map.getOrDefault(string, 0) + 1);
			}

			Integer queries = in.nextInt();
			in.nextLine();

			for (Integer i = 0; i < queries; ++i)
			{
				String query = in.next();

				System.out.println(map.getOrDefault(query, 0));
			}
		}
	}
}