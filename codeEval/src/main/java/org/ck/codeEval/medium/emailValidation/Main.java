package org.ck.codeEval.medium.emailValidation;

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
				
				boolean result = line.matches("^[a-zA-Z0-9]([\\+\\.\\-_][a-zA-Z0-9]|[a-zA-Z0-9])*@[a-zA-Z0-9]([\\.\\-][a-zA-Z0-9]|[a-zA-Z0-9])*?\\.[a-zA-Z0-9]+$");
				
				System.out.println(result || line.matches("^\".*?\"@[a-zA-Z0-9]([\\.\\-][a-zA-Z0-9]|[a-zA-Z0-9])*?\\.[a-zA-Z0-9]+$"));
			}
		}
	}
}