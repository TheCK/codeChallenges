package org.ck.codeeval.medium.columnnames;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Solution(id = 197, name = "Column Names", description = "Convert integer to excel-style column name", url = "https://www.codeeval.com/open_challenges/197/", category = "Moderate challenges")
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
				int columnNumber = Integer.parseInt(line) - 1;

				char third = '@';
				char second = '@';
				char first = 'A';

				for (int i = columnNumber; i > 0; --i)
				{
					++first;

					if (first == '[')
					{
						++second;
						first = 'A';
					}

					if (second == '[')
					{
						++third;
						second = 'A';
					}
				}

				System.out.println("" + (third != '@' ? third : "") + (second != '@' ? second : "") + first);
			}
		}
	}
}