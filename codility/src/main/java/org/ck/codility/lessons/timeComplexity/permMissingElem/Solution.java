package org.ck.codility.lessons.timeComplexity.permMissingElem;

@org.ck.codeChallengeLib.annotation.Solution(id = 2, name = "PermMissingElem", description = "Find the missing element in a given permutation.", url = "https://codility.com/programmers/lessons/1", category = "Lessons", subCategory = "1. Time Complexity")
class Solution
{
	public int solution(int[] A)
	{
		int sum = 0;

		for (int i = 1; i <= A.length + 1; ++i)
		{
			sum += i;
		}

		for (int i = 0; i < A.length; ++i)
		{
			sum -= A[i];
		}

		return sum;
	}
}