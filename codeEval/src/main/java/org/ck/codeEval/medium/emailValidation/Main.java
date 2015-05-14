package org.ck.codeEval.medium.emailValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 35, name = "Email Validation", description = "Write a regular expression to validate an email address", url = "https://www.codeeval.com/open_challenges/35/", category = "Moderate challenges")
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
				
				boolean result = line.matches("^[a-zA-Z0-9]([\\+\\.\\-_][a-zA-Z0-9]|[a-zA-Z0-9])*@[a-zA-Z0-9]([\\.\\-][a-zA-Z0-9]|[a-zA-Z0-9])*?\\.[a-zA-Z0-9]+$");
				
				System.out.println(result || line.matches("^\".*?\"@[a-zA-Z0-9]([\\.\\-][a-zA-Z0-9]|[a-zA-Z0-9])*?\\.[a-zA-Z0-9]+$"));
			}
		}
	}
}