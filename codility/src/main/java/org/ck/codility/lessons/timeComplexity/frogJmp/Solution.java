package org.ck.codility.lessons.timeComplexity.frogJmp;

@org.ck.codeChallengeLib.annotation.Solution(id = 3, name = "FrogJmp", url = "https://codility.com/programmers/lessons/1", category = "Lessons", subCategory = "Time Complexity")
class Solution
{
	public int solution(int X, int Y, int D)
	{
		int difference = (Y - X);
		int jumps = difference / D;

		if (difference % D != 0)
		{
			++jumps;
		}
		return jumps;
	}
}