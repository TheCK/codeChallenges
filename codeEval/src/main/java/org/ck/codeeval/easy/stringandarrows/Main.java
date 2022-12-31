package org.ck.codeeval.easy.stringandarrows;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Solution(id=203, name="Strings and arrows", description="Print the number of arrows in a string", url="https://www.codeeval.com/open_challenges/203/", category="Easy challenges")
public class Main
{
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				int arrowCount = 0;

				for (int i = 0; i < line.length() - 4; ++i)
				{
					String possibleArrow = line.substring(i, i + 5);
					if(">>-->".equals(possibleArrow) || "<--<<".equals(possibleArrow))
					{
						++arrowCount;
						i = i + 3;
					}
				}
				
				System.out.println(arrowCount);
			}
		}
	}
}