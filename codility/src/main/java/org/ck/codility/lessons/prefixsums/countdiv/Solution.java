package org.ck.codility.lessons.prefixsums.countdiv;

@org.ck.codechallengelib.annotation.Solution(
		id = 21, name = "CountDiv",
		description = "Compute number of integers divisible by k in range [a..b].",
		url = "https://codility.com/programmers/lessons/3",
		category = "Lessons",
		subCategory = "3. Prefix Sums",
		solved = false)
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

		return (int) count;
	}
}
