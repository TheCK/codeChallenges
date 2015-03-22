package org.ck.codeEval.medium.decodeNumbers;

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

				int count = decode(line);
				
				System.out.println(count);
			}
		}
	}

	private static int decode(String line)
	{
		if (line.length() == 0)
		{
			return 1;
		}
		
		int interpretSingle = decode(line.substring(1));
		int decodeDouble = 0;
		
		if (line.length() >= 2 && Integer.parseInt(line.substring(0, 2)) <= 26)
		{
			decodeDouble = decode(line.substring(2));
		}
		
		
		return interpretSingle + decodeDouble;
	}
}