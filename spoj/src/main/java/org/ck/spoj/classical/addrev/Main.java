package org.ck.spoj.classical.addrev;

import org.ck.codechallengelib.annotation.Solution;

import java.io.IOException;
import java.util.Scanner;

@Solution(
		id = 1000042,
		name = "ADDREV - Adding Reversed Numbers",
		url = "http://www.spoj.com/problems/ADDREV/",
		category = "classical"
)
public class Main
{
	public static void main(String[] args) throws IOException
	{
		try (Scanner in = new Scanner(System.in))
		{
			long numberOfTestCases = in.nextLong();
			for (int i = 0; i < numberOfTestCases; ++i)
			{
				long m = in.nextLong();
				long n = in.nextLong();

				long revertedM = revert(m);
				long revertedN = revert(n);

				System.out.println(revert(revertedM + revertedN));
			}
		}
	}

	private static long revert(long m)
	{
		StringBuilder builder = new StringBuilder(String.valueOf(m));
		builder.reverse();

		return Long.parseLong(builder.toString());
	}
}