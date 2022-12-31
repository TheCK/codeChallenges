package org.ck.codeeval.medium.doubleSquares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 33, name = "Double Squares", description = "FaceBook Hacker Cup 2011: Output the number of ways to write X as the sum of two squares", url = "https://www.codeeval.com/open_challenges/33/", category = "Moderate challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			line = buffer.readLine();
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				int result = Integer.parseInt(line);
				
				int realSqrt = (int) Math.sqrt(result);
				
				int upperBoundary = result / 2;
				int sqrt = (int) Math.sqrt(upperBoundary);
				
				int combinations = 0;
				for (int i = 1; i <= sqrt; ++i)
				{
					int remainder = result - (i * i);
					int remainderSqrt = (int) Math.sqrt(remainder);
					
					if (remainderSqrt * remainderSqrt == remainder)
					{
						++combinations;
					}
				}
				
				if (realSqrt * realSqrt == result)
				{
					++combinations;
				}
				
				System.out.println(combinations);
			}
		}
	}
}