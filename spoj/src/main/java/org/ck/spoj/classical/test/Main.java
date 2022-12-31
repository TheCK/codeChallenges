package org.ck.spoj.classical.test;

import org.ck.codechallengelib.annotation.Solution;

import java.io.IOException;
import java.util.Scanner;

@Solution(
		id = 1000001,
		name = "TEST - Life, the Universe, and Everything",
		url = "http://www.spoj.com/problems/TEST/",
		category = "classical"
)
public class Main
{
	public static void main(String[] args) throws IOException
	{
		try (Scanner in = new Scanner(System.in))
		{
			int number = in.nextInt();
			while (number != 42)
			{
				System.out.println(number);

				number = in.nextInt();
			}
		}
	}
}