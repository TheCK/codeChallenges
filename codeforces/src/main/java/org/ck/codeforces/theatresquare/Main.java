package org.ck.codeforces.theatresquare;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.IOException;
import java.util.Scanner;

@Solution(
		id = 101,
		name = "A. Theatre Square",
		url = "http://codeforces.com/problemset/problem/1/A",
		category = ""
)
public class Main
{
	public static void main(String[] args) throws IOException
	{
		try (Scanner in = new Scanner(System.in))
		{
			long n = in.nextLong();
			long m = in.nextLong();
			long a = in.nextLong();

			long horizontalTiles = (long) Math.ceil((double) n / a);
			long verticalTiles = (long) Math.ceil((double) m / a);

			System.out.println(horizontalTiles * verticalTiles);
		}
	}
}