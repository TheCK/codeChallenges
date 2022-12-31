package org.ck.codeeval.easy.hiddenDigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 122, name = "Hidden Digits", description = "Try to look behind the scenes", url = "https://www.codeeval.com/open_challenges/122/", category = "Easy challenges")
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

				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < line.length(); ++i)
				{
					if (line.substring(i, i +1).equals("a"))
					{
						builder.append("0");
					}
					else if (line.substring(i, i +1).equals("b"))
					{
						builder.append("1");
					}
					else if (line.substring(i, i +1).equals("c"))
					{
						builder.append("2");
					}
					else if (line.substring(i, i +1).equals("d"))
					{
						builder.append("3");
					}
					else if (line.substring(i, i +1).equals("e"))
					{
						builder.append("4");
					}
					else if (line.substring(i, i +1).equals("f"))
					{
						builder.append("5");
					}
					else if (line.substring(i, i +1).equals("g"))
					{
						builder.append("6");
					}
					else if (line.substring(i, i +1).equals("h"))
					{
						builder.append("7");
					}
					else if (line.substring(i, i +1).equals("i"))
					{
						builder.append("8");
					}
					else if (line.substring(i, i +1).equals("j"))
					{
						builder.append("9");
					}
					else if (line.substring(i, i +1).matches("[0-9]"))
					{
						builder.append(line.substring(i, i +1));
					}
				}

				if (builder.length() == 0)
				{
					builder.append("NONE");
				}
				System.out.println(builder);
			}
		}
	}
}