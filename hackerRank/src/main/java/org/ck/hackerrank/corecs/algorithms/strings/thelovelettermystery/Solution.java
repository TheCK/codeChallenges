package org.ck.hackerrank.corecs.algorithms.strings.thelovelettermystery;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10314,
		name = "The Love-Letter Mystery",
		url = "https://www.hackerrank.com/challenges/the-love-letter-mystery",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int count = in.nextInt();
			in.nextLine();

			for (int i = 0; i < count; ++i)
			{
				int changes = 0;
				String line = in.nextLine();

				for (int position = 0; position < line.length() / 2; ++position)
				{
					char first = line.charAt(position);
					char last = line.charAt(line.length() - 1 - position);

					int diff = Math.abs(last - first);
					changes += diff;
				}

				System.out.println(changes);
			}
		}
	}
}