package org.ck.codeEval.medium.minimumCoins;

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

				Integer amount = Integer.valueOf(line);
				
				Integer sum = 0;
				while (amount != 0)
				{
					if (amount >= 5)
					{
						amount -= 5;
						sum++;
					}
					else if (amount >= 3)
					{
						amount -= 3;
						sum++;
					}
					else if (amount >= 1)
					{
						amount -= 1;
						sum++;
					}
				}
				System.out.println(sum);
			}
		}
	}
}