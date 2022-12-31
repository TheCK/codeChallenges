package org.ck.codility.lessons.countingelements.frogeiverone;

import java.util.HashSet;
import java.util.Set;

@org.ck.codechallengelib.annotation.Solution(id = 11, name = "FrogRiverOne", description = "Find the earliest time when a frog can jump to the other side of a river.", url = "https://codility.com/programmers/lessons/2", category = "Lessons", subCategory = "2. Counting Elements")
public class Solution
{
	public int solution(int X, int[] A)
	{
		Set<Integer> leaves = new HashSet<>(X, 1);

		int when = -1;

		for (int i = 0; i < A.length; ++i)
		{
			if (A[i] <= X)
			{
				if (!leaves.contains(A[i]))
				{
					leaves.add(A[i]);

					if (leaves.size() == X)
					{
						when = i;
						break;
					}
				}
			}
		}

		return when;
	}
}
