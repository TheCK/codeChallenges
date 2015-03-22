package org.ck.codeEval.medium.reverseGroups;

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
				String[] arguments = line.split(";");
				
				String[] array = arguments[0].split(",");
				int chunkSize = Integer.parseInt(arguments[1]);
				
				for (int i = 0; i < array.length / chunkSize; ++i)
				{
					String[] tempArray = new String[chunkSize];
					
					int start = (i * chunkSize);
					for (int j = 0; j < chunkSize; ++j)
					{
						tempArray[chunkSize - j - 1] = array[start + j];
					}
					
					for (int j = 0; j < chunkSize; ++j)
					{
						array[start + j] = tempArray[j];
					}
				}
				
				StringBuilder builder = new StringBuilder();
				for (String element : array)
				{
					builder.append(element + ",");
				}
				
				if (builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				System.out.println(builder);
			}
		}
	}
}