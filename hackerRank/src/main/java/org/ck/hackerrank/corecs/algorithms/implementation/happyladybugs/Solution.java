package org.ck.hackerrank.corecs.algorithms.implementation.happyladybugs;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(
		id = 10252,
		name = "Flatland Space Stations",
		url = "https://www.hackerrank.com/challenges/flatland-space-stations",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int testCases = in.nextInt();

			for (int testCase = 0; testCase < testCases; ++testCase)
			{
				int length = in.nextInt();
				in.nextLine();

				String line = in.nextLine();
				int[] bugs = new int[length];
				for (int i = 0; i < length; ++i)
				{
					bugs[i] = line.charAt(i);
				}

				Map<Integer, Long> groupedByCount = Arrays.stream(bugs)
						.boxed()
						.collect(Collectors.groupingBy(bug -> bug, Collectors.counting()));

				boolean happyBugs = true;
				if (groupedByCount.keySet().contains((int) '_'))
				{
					for (Integer key : groupedByCount.keySet())
					{

						if (!key.equals((int) '_') && groupedByCount.get(key) == 1)
						{
							happyBugs = false;
							break;
						}
					}
				}
				else
				{
					if (length == 1)
					{
						happyBugs = false;
					}
					else
					{
						for (int i = 0; i < length; ++i)
						{
							boolean thisBugIsHappy = false;

							if (i > 0)
							{
								thisBugIsHappy |= bugs[i - 1] == bugs[i];
							}

							if (i < length - 1)
							{
								thisBugIsHappy |= bugs[i] == bugs[i + 1];
							}

							happyBugs &= thisBugIsHappy;
						}
					}
				}

				System.out.println(happyBugs ? "YES" : "NO");
			}
		}
	}
}