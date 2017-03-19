package org.ck.hackerRank.languages.java.introduction.datatypes;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 40201008,
		name = "Java Datatypes",
		url = "https://www.hackerrank.com/challenges/java-datatypes",
		category = "Java",
		subCategory = "Introduction"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int cases = in.nextInt();

			for (int i = 0; i < cases; ++i)
			{
				String wouldBeNumber = in.next();

				boolean fitsByte = true;
				boolean fitsShort = true;
				boolean fitsInt = true;
				boolean fitsLong = true;

				try
				{
					Byte.valueOf(wouldBeNumber);
				}
				catch (NumberFormatException e)
				{
					fitsByte = false;
				}

				try
				{
					Short.valueOf(wouldBeNumber);
				}
				catch (NumberFormatException e)
				{
					fitsShort = false;
				}

				try
				{
					Integer.valueOf(wouldBeNumber);
				}
				catch (NumberFormatException e)
				{
					fitsInt = false;
				}

				try
				{
					Long.valueOf(wouldBeNumber);
				}
				catch (NumberFormatException e)
				{
					fitsLong = false;
				}

				if (!fitsByte && !fitsShort && !fitsInt && !fitsLong)
				{
					System.out.println(wouldBeNumber + " can't be fitted anywhere.");
				}
				else
				{
					System.out.println(wouldBeNumber + " can be fitted in:");
					if (fitsByte)
					{
						System.out.println("* byte");
					}
					if (fitsShort)
					{
						System.out.println("* short");
					}
					if (fitsInt)
					{
						System.out.println("* int");
					}
					if (fitsLong)
					{
						System.out.println("* long");
					}
				}
			}
		}
	}
}