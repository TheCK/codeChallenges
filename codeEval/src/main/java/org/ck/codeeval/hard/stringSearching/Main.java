package org.ck.codeeval.hard.stringSearching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 28, name = "String Searching", description = "Determine if substring match exists.", url = "https://www.codeeval.com/open_challenges/28/", category = "Hard challenges")
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
				String[] value = line.split(",");
				String text = value[0];
				String exp = value[1];
				
				exp = exp.replace("\\*", "#");
				exp = exp.replace("*", ".*");
				exp = exp.replace("#", "\\*");
				exp = ".*?" + exp + ".*";
				
				System.out.println(text.matches(exp));
			}
		}
	}
}