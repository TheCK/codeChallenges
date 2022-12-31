package org.ck.codility.lessons.countingelements.permcheck;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(id = 12, name = "PermCheck", description = "Check whether array A is a permutation.", url = "https://codility.com/programmers/lessons/2", category = "Lessons", subCategory = "2. Counting Elements")
public class Solution
{
	public int solution(int[] A)
	{
		Set<Integer> occurrences = new HashSet<>(Arrays.stream(A).boxed().collect(Collectors.toList()));

		if (occurrences.size() == A.length)
		{
			int min = occurrences.stream().mapToInt(x -> x).min().getAsInt();
			int max = occurrences.stream().mapToInt(x -> x).max().getAsInt();

			if (min == 1 && max == A.length)
			{
				return 1;
			}
		}

		return 0;
	}
}
