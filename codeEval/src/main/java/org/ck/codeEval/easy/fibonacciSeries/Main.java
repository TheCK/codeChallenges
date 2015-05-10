package org.ck.codeEval.easy.fibonacciSeries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 22, name = "Fibonacci Series", description = "Print out the nth fibonacci number", url = "https://www.codeeval.com/open_challenges/22/", category = "Easy challenges")
public class Main
{
	private static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				Integer n = Integer.valueOf(line);
				
				System.out.println(getFib(n));
			}
		}
	}

	private static Integer getFib(Integer n)
	{
		if (n == 0)
		{
			return 0;
		}
		if (n == 1)
		{
			return 1;
		}
		
		if (cache.containsKey(n))
		{
			return cache.get(n);
		}
		
		Integer fibN = getFib(n - 1) + getFib(n - 2);
		cache.put(n, fibN);
		
		return fibN;
	}
}
