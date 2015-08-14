package org.ck.codility.challenges.alpha2010;

import java.util.HashSet;
import java.util.Set;

@org.ck.codeChallengeLib.annotation.Solution(id = 1001, name = "Alpha 2010 (PrefixSet)", url = "https://codility.com/programmers/challenges/alpha2010", category = "Challenges", subCategory = "Greeks")
class Solution
{
	public int solution(int[] A)
	{
		Set<Integer> occurrences = new HashSet<>();

		int lastInsertIndex = 0;

		for (int i = 0; i < A.length; ++i)
		{
			if (!occurrences.contains(A[i]))
			{
				occurrences.add(A[i]);
				lastInsertIndex = i;
			}
		}

		return lastInsertIndex;
	}
}