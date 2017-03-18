package org.ck.hackerRank.corecs.algorithms.implementation.cutthesticks;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10229,
		name = "Cut the sticks",
		url = "https://www.hackerrank.com/challenges/cut-the-sticks",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer count = in.nextInt();

			List<Integer> sticks = new ArrayList<>();
			for (int i = 0; i < count; ++i)
			{
				sticks.add(in.nextInt());
			}

			while (sticks.size() != 0)
			{
				System.out.println(sticks.size());

				OptionalInt minStick = sticks.stream().mapToInt(stick -> stick).min();

				sticks = sticks.stream()
						.map(stick -> stick - minStick.getAsInt())
						.filter(stick -> stick > 0)
						.collect(Collectors.toList());
			}
		}
	}
}