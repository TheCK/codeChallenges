package org.ck.projectEuler.solutions.problem006;

import java.util.stream.StreamSupport;

import org.ck.projectEuler.lib.iterators.IntSpliterator;

public class Problem
{
	public static void main(String[] args)
	{
		int sumOfQuares = StreamSupport.intStream(new IntSpliterator(1, 101, x -> x + 1, x -> x * x), false).sum();

		int sum = (100 + 1) * 50;
		int squareOfSums = sum * sum;
		
		System.out.println(Math.abs(sumOfQuares - squareOfSums));
	}
}
