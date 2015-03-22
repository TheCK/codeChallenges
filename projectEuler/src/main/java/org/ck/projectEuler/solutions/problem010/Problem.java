package org.ck.projectEuler.solutions.problem010;

import java.util.stream.StreamSupport;

import org.ck.projectEuler.lib.iterators.PrimesSpliterator;

public class Problem
{
	public static void main(String[] args)
	{
		long result = StreamSupport.intStream(new PrimesSpliterator(2000000), false).mapToLong(x -> 1L * x).sum();
		
		System.out.println(result);
	}
}
