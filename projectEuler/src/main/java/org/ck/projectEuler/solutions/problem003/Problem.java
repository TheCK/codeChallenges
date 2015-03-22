package org.ck.projectEuler.solutions.problem003;

import java.util.OptionalLong;

import org.ck.projectEuler.lib.MyMath;

public class Problem
{
	public static void main(String[] args)
	{
		OptionalLong result = MyMath.getDivisors(600851475143L).stream().mapToLong(x -> x).filter(MyMath::isPrime).max();
		
		System.out.println(result.getAsLong());
	}
}
