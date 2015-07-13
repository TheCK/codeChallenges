package org.ck.projectEuler.solutions.problem005;

import org.ck.projectEuler.lib.iterators.IntSpliterator;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;

public class SmallestMultiple
{
	public static void main(String[] args)
	{
		OptionalInt result = StreamSupport.intStream(new IntSpliterator(20, 1000000000, x -> x + 20), true)
				.filter(x -> x % 19 == 0)
				.filter(x -> x % 18 == 0)
				.filter(x -> x % 17 == 0)
				.filter(x -> x % 16 == 0)
				.filter(x -> x % 15 == 0)
				.filter(x -> x % 14 == 0)
				.filter(x -> x % 13 == 0)
				.filter(x -> x % 12 == 0)
				.filter(x -> x % 11 == 0)
				.min();

		System.out.println(result.getAsInt());
	}
}
