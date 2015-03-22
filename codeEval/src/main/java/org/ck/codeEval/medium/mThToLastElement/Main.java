package org.ck.codeEval.medium.mThToLastElement;

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
				String[] array = line.split(" ");

				Integer index = Integer.valueOf(array[array.length - 1]);
				if (index < array.length)
				{
					System.out.println(array[array.length - 1 - index]);
				}
			}
		}
	}
}