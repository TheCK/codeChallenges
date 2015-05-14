package org.ck.codeEval.medium.balancedSmileys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 84, name = "Balanced Smileys", description = "Facebook Hacker Cup 2013 problem.", url = "https://www.codeeval.com/open_challenges/84/", category = "Moderate challenges", solved = false)
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
			}
		}
	}
}