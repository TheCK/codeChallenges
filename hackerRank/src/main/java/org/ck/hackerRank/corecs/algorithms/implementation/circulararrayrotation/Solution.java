package org.ck.hackerRank.corecs.algorithms.implementation.circulararrayrotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10221,
		name = "Circular Array Rotation",
		url = "https://www.hackerrank.com/challenges/circular-array-rotation",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();
			int k = in.nextInt();
			int q = in.nextInt();

			List<Integer> array = new ArrayList<>();
			for (int i = 0; i < n; ++i)
			{
				array.add(in.nextInt());
			}

			Collections.rotate(array, k);

			for (int i = 0; i < q; ++i)
			{
				System.out.println(array.get(in.nextInt()));
			}
		}
	}
}