package org.ck.hackerrank.corecs.algorithms.implementation.equalizethearray;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@org.ck.codechallengelib.annotation.Solution(
		id = 10233,
		name = "Equalize the Array",
		url = "https://www.hackerrank.com/challenges/equality-in-a-array",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();

			int[] array = new int[n];
			for (int i = 0; i < n; ++i)
			{
				array[i] = in.nextInt();
			}

			Map<Integer, Long> countOfMembers = Arrays.stream(array)
					.boxed()
					.collect(groupingBy(member -> member, counting()));

			Optional<Map.Entry<Integer, Long>> maxOccurredMember = countOfMembers.entrySet()
					.stream()
					.max(Comparator.comparing(Map.Entry::getValue));

			System.out.println(n - maxOccurredMember.get().getValue());
		}
	}
}