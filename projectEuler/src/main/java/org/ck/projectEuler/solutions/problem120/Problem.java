package org.ck.projectEuler.solutions.problem120;

import java.util.stream.IntStream;

public class Problem
{
	public static void main(String[] args)
	{
		int result = IntStream.rangeClosed(3, 1000).map(x -> 2 * x * ((x - 1) / 2)).sum();
		
		System.out.println(result);
	}
}
