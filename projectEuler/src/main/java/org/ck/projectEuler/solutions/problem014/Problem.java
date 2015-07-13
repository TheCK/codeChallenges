package org.ck.projectEuler.solutions.problem014;

import org.ck.projectEuler.lib.iterators.IntSpliterator;

import java.util.Optional;
import java.util.stream.StreamSupport;

public class Problem
{
	public static void main(String[] args)
	{
		Optional<Collatz> result = StreamSupport.intStream(new IntSpliterator(1, 1000000), true)
				.mapToObj(x -> new Collatz(x, getCollatzChainLength(x)))
				.max((x, y) -> (new Long(x.getCollatzChainLength())).compareTo(y.getCollatzChainLength()));

		System.out.println(result.get().getStartingNumber());
	}

	private static long getCollatzChainLength(long number)
	{
		long chainLength = 1;

		while (number != 1)
		{
			chainLength++;

			if (number % 2 == 0)
			{
				number /= 2;
			}
			else
			{
				number = (3 * number) + 1;
			}
		}

		return chainLength;
	}

	private static class Collatz
	{
		long startingNumber;
		long collatzChainLength;

		public Collatz(long startingNumber, long collatzChainLength)
		{
			this.startingNumber = startingNumber;
			this.collatzChainLength = collatzChainLength;
		}

		public long getStartingNumber()
		{
			return startingNumber;
		}

		public long getCollatzChainLength()
		{
			return collatzChainLength;
		}
	}
}
