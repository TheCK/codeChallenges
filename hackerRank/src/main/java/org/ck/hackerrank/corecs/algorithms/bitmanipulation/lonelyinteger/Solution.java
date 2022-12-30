package org.ck.hackerrank.corecs.algorithms.bitmanipulation.lonelyinteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 11001,
		name = "Lonely Integer",
		url = "https://www.hackerrank.com/challenges/lonely-integer",
		category = "Algorithms",
		subCategory = "Bit Manipulation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = in.nextInt();

			List<Integer> array = new ArrayList<>();
			for (int i = 0; i < count; ++i)
			{
				array.add(in.nextInt());
			}

			array.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(x -> 1))).forEach((key, value) ->
			{
				if (value == 1)
				{
					System.out.println(key);
				}
			});
		}
	}
}