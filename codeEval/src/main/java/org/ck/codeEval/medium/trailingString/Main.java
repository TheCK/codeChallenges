package org.ck.codeEval.medium.trailingString;

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
				String[] values = line.split(",");
				
				System.out.println(values[0].endsWith(values[1]) ? 1 : 0);
			}
		}
	}
}