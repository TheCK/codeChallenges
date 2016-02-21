package org.ck.codility.lessons.prefixSums.countDiv;

@org.ck.codeChallengeLib.annotation.Solution(id = 21, name = "CountDiv", description = "Compute number of integers divisible by k in range [a..b].", url = "https://codility.com/programmers/lessons/3", category = "Lessons", subCategory = "3. Prefix Sums")
public class Solution
{
	public int solution(int A, int B, int K)
	{
		long countOfNumbers = ((long) B) - A + 1;

		long count = (int) (countOfNumbers / K);

		if (count < K)
		{
			if (A % K == 0)
			{
				++count;
			}
			if (A != B && B % K == 0)
			{
				++count;
			}
		}

		return count;
	}
}
