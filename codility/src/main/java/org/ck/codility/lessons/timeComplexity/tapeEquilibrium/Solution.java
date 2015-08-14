package org.ck.codility.lessons.timeComplexity.tapeEquilibrium;

@org.ck.codeChallengeLib.annotation.Solution(id = 1, name = "TapeEquilibrium", url = "https://codility.com/programmers/lessons/1", category = "Lessons", subCategory = "Time Complexity")
class Solution
{
	public int solution(int[] A)
	{
		long sumRemaining = 0;

		for (int i = 0; i < A.length; ++i)
		{
			sumRemaining += A[i];
		}

		long sumSoFar = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < A.length - 1; ++i)
		{
			sumSoFar += A[i];
			sumRemaining -= A[i];

			long diff = sumSoFar - sumRemaining;

			if (diff < 0)
			{
				diff *= -1;
			}

			if (diff < min)
			{
				min = (int) diff;
			}
		}

		return min;
	}
}