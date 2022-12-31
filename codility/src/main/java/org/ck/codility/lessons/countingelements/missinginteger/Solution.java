package org.ck.codility.lessons.countingelements.missinginteger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@org.ck.codechallengelib.annotation.Solution(id = 13, name = "MissingInteger", description = "Find the minimal positive integer not occurring in a given sequence.", url = "https://codility.com/programmers/lessons/2", category = "Lessons", subCategory = "2. Counting Elements")
public class Solution
{
	public int solution(int[] A)
	{
		Set<Integer> occurrences = new HashSet<>(Arrays.stream(A).boxed().collect(Collectors.toList()));

		for (int i = 1; i <= A.length; ++i)
		{
			if (!occurrences.contains(i))
			{
				return i;
			}
		}

		return A.length + 1;
	}
}
