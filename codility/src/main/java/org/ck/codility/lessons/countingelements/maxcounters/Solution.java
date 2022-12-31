package org.ck.codility.lessons.countingelements.maxcounters;

@org.ck.codechallengelib.annotation.Solution(id = 14, name = "MaxCounters", description = "Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.", url = "https://codility.com/programmers/lessons/2", category = "Lessons", subCategory = "2. Counting Elements")
public class Solution
{
	public int[] solution(int N, int[] A)
	{
		int[] counters = new int[N];
		int max = 0;
		int newVal = 0;

		for (int command : A)
		{
			if (command <= N)
			{
				if (counters[command - 1] < newVal)
				{
					counters[command - 1] = newVal + 1;
				}
				else
				{
					counters[command - 1]++;
				}

				if (counters[command - 1] > max)
				{
					max = counters[command - 1];
				}
			}
			else
			{
				newVal = max;
			}
		}

		for (int i = 0; i < N; ++i)
		{
			if (counters[i] < newVal)
			{
				counters[i] = newVal;
			}
		}

		return counters;
	}
}
