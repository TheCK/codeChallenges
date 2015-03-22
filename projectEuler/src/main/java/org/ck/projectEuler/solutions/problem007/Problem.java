package org.ck.projectEuler.solutions.problem007;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;

import org.ck.projectEuler.lib.iterators.PrimesSpliterator;

public class Problem
{
	public static void main(String[] args)
	{
		OptionalInt result = StreamSupport.intStream(new PrimesSpliterator(500000), false).limit(10001).max();
		
		System.out.println(result.getAsInt());
	}
}
