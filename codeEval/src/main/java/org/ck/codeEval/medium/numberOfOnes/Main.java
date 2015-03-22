package org.ck.codeEval.medium.numberOfOnes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				Integer number = Integer.valueOf(line);

				System.out.println(Integer.bitCount(number));
			}
		}
	}
}