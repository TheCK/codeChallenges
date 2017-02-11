package org.ck.hackerRank.algorithms.implementation.strangecounter;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10242,
		name = "Strange Counter",
		url = "https://www.hackerrank.com/challenges/strange-code",
		category = "Algorithms",
		subCategory = "Implementation",
		solved = false
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			long time = in.nextLong();
			System.err.println("time: " + time);

			long cycles = (long) (Math.log(time) / Math.log(3));
			System.err.println("cycles: " + cycles);

			long maxThisCycle = (long) Math.pow(2, cycles) * 3;
			System.err.println("maxThis: " + maxThisCycle);

			long passedCycles = 0;
			for (long i = 0; i < cycles; ++i)
			{
				passedCycles += (long) Math.pow(2, i) * 3;
			}
			System.err.println("passed: " + passedCycles);
			System.err.println("remaining: " + (time - passedCycles - 1));

			System.out.println(maxThisCycle - (time - passedCycles - 1));
		}
	}
}