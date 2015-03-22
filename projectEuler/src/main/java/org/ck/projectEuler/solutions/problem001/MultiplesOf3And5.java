package org.ck.projectEuler.solutions.problem001;

import java.util.stream.IntStream;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 1, name = "Multiples of 3 and 5", url = "https://projecteuler.net/problem=1", category = "Problems 1 - 50")
public class MultiplesOf3And5
{
	public static void main(String[] args)
	{
		System.out.println(IntStream.iterate(0, x -> x + 1).limit(1000).filter(x -> x % 3 == 0 || x % 5 == 0).sum());
	}
}
