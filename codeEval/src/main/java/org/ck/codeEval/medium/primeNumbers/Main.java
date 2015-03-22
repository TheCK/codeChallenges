package org.ck.codeEval.medium.primeNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main
{
	private static int BORDER = 32;

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				long max = Long.parseLong(line);

				int numberOfInts = ((int) (max / BORDER)) + 1;
				int[] primeNumbers = new int[numberOfInts];

				for (int i = 0; i < numberOfInts; ++i)
				{
					primeNumbers[i] = -1;
				}

				for (long divider = 2; divider < Math.sqrt(max); ++divider)
				{
					if (get(primeNumbers, divider))
					{
						for (long i = divider * 2; i <= max; i += divider)
						{
							setFalse(primeNumbers, i);
						}
					}
				}

				StringBuilder builder = new StringBuilder();
				for (long i = 2; i < max; ++i)
				{
					if (get(primeNumbers, i))
					{
						builder.append(i + ",");
					}
				}

				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}

				System.out.println(builder);
			}
		}
	}

	private static boolean get(int[] primeNumbers, long i)
	{
		int field = (int) (i / BORDER);
		int bit = (int) (i % BORDER);

		int mask = 1;
		mask = mask << (BORDER - bit - 1);

		return (primeNumbers[field] & mask) != 0;
	}

	private static void setFalse(int[] primeNumbers, long i)
	{
		int field = (int) (i / BORDER);
		int bit = (int) (i % BORDER);

		int mask = 1;
		mask = mask << (BORDER - bit - 1);
		mask = mask ^ -1;

		primeNumbers[field] = primeNumbers[field] & mask;
	}
}