package org.ck.projectEuler.solutions.problem012;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;

import org.ck.projectEuler.lib.MyMath;
import org.ck.projectEuler.lib.iterators.TriangleSpliterator;

public class Problem
{
	public static void main(String[] args)
	{
		OptionalInt result = StreamSupport.intStream(new TriangleSpliterator(1, 100000000), false).filter(x -> MyMath.getDivisors(x).size() > 500).findFirst();
		
		System.out.println(result.getAsInt());
	}
}
