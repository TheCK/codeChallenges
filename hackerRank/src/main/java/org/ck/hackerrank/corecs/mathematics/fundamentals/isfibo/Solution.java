package org.ck.hackerrank.corecs.mathematics.fundamentals.isfibo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@org.ck.codechallengelib.annotation.Solution(
		id = 30120,
		name = "Is Fibo",
		url = "https://www.hackerrank.com/challenges/is-fibo",
		category = "Mathematics",
		subCategory = "Fundamentals"
)
public class Solution
{
	private static final Set<Long> fibs = new HashSet<>();

	public static void main(String[] args)
	{
		initFibs();

		try (Scanner in = new Scanner(System.in))
		{
			int cases = in.nextInt();

			for (int i = 0; i < cases; ++i)
			{
				long number = in.nextLong();

				System.out.println(fibs.contains(number) ? "IsFibo" : "IsNotFibo");
			}
		}
	}

	private static void initFibs()
	{
		fibs.add(0L);
		fibs.add(1L);

		long n2 = 0;
		long n1 = 1;

		while (n1 < 10000000000L)
		{
			long temp = n2 + n1;
			fibs.add(temp);

			n2 = n1;
			n1 = temp;
		}
	}
}