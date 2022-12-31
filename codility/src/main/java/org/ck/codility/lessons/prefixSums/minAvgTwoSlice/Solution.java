package org.ck.codility.lessons.prefixSums.minAvgTwoSlice;

@org.ck.codechallengelib.annotation.Solution(
		id = 23, name = "MinAvgTwoSlice",
		description = "Find the minimal average of any slice containing at least two elements.",
		url = "https://codility.com/programmers/lessons/3",
		category = "Lessons",
		subCategory = "3. Prefix Sums",
		solved = false)
class Solution
{
	public int solution(int[] A)
	{
		int prefixSums[] = new int[A.length + 1];

		prefixSums[0] = 0;
		for (int i = 1; i <= A.length; ++i)
		{
			prefixSums[i] = prefixSums[i - 1] + A[i - 1];
		}

		return 0;
	}
}