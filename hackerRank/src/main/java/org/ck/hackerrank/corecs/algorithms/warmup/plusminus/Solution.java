package org.ck.hackerrank.corecs.algorithms.warmup.plusminus;

import java.util.Locale;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10106,
		name = "Plus Minus",
		url = "https://www.hackerrank.com/challenges/plus-minus",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = in.nextInt();

			int negatives = 0;
			int positives = 0;
			for (int i = 0; i < count; ++i)
			{
				int number = in.nextInt();

				if (number < 0)
				{
					++negatives;
				}
				else if (number > 0)
				{
					++positives;
				}
			}

			System.out.println(String.format(Locale.US, "%.6f", (float) positives / count));
			System.out.println(String.format(Locale.US, "%.6f", (float) negatives / count));
			System.out.println(String.format(Locale.US, "%.6f", (float) (count - negatives - positives) / count));
		}
	}
}