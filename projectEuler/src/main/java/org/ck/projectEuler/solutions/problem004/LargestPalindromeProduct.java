package org.ck.projectEuler.solutions.problem004;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;

import org.ck.projectEuler.lib.MyMath;
import org.ck.projectEuler.lib.iterators.IntDoubleLoopSpliterator;

public class LargestPalindromeProduct
{
	public static void main(String[] args)
	{
		OptionalInt result = StreamSupport.intStream(new IntDoubleLoopSpliterator(999, 99, 999, 99, x -> x - 1, (x, y) -> x * y), false)
				.filter(MyMath::isPalindrome)
				.max();

		System.out.println(result.getAsInt());
	}
}
