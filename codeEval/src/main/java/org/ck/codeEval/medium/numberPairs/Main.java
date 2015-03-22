package org.ck.codeEval.medium.numberPairs;

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
				if (line.length() > 3)
				{
					String[] values = line.split(";");
					
					Integer sum = Integer.valueOf(values[1]);
					String[] array = values[0].split(",");
					
					StringBuilder builder = new StringBuilder();
					for (int i = 0; i < array.length - 1; ++i)
					{
						for (int j = i + 1; j < array.length; ++j)
						{
							if (sum == Integer.valueOf(array[i]) + Integer.valueOf(array[j]))
							{
								builder.append(array[i] + "," + array[j] + ";");
							}
						}
					}
					if (builder.length() > 1)
					{
						builder.deleteCharAt(builder.length() - 1);
						System.out.println(builder);
					}
					else
					{
						System.out.println("NULL");
					}
				}
			}
		}
	}
}