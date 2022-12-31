package org.ck.codility.lessons.prefixsums.passingcars;

@org.ck.codechallengelib.annotation.Solution(id = 22, name = "PassingCars", description = "Count the number of passing cars on the road.", url = "https://codility.com/programmers/lessons/3", category = "Lessons", subCategory = "3. Prefix Sums")
class Solution
{
	public int solution(int[] A)
	{
		int westBound = 0;

		for (int i : A)
		{
			if (i == 1)
			{
				++westBound;
			}
		}

		long sum = 0;

		for (int i : A)
		{
			if (i == 0)
			{
				sum += westBound;
			}
			else
			{
				--westBound;
			}
		}

		return sum > 1000000000 ? -1 : (int) sum;
	}
}