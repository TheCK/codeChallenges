package org.ck.projectEuler.solutions.problem009;

public class Problem
{
	public static void main(String[] args)
	{
		for (int a = 1; a < 999; ++a)
		{
			int aSquared = a * a;
			
			for (int b = 1; b < 999; ++b)
			{
				if (a + b > 1000)
				{
					break;
				}
				
				int bSquared = b * b;
				
				int sum = aSquared + bSquared;
				int sumRoot = (int) Math.sqrt(sum);
				
				if (sumRoot * sumRoot == sum && a + b + sumRoot == 1000)
				{
					System.out.println(a * b * sumRoot);
					return;
				}
			}
		}
	}
}
