package org.ck.codeEval.medium.validParentheses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.EmptyStackException;
import java.util.Stack;

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

				boolean valid = true;

				Stack<Character> stack = new Stack<>();
				for (Character letter : line.toCharArray())
				{
					if (letter.equals('(') || letter.equals('{') || letter.equals('['))
					{
						stack.push(letter);
					}
					if (letter.equals(')') || letter.equals('}') || letter.equals(']'))
					{
						try
						{
							Character openingParentheses = stack.pop();

							if (openingParentheses.equals('(') && !letter.equals(')'))
							{
								valid = false;
								break;
							}
							if (openingParentheses.equals('{') && !letter.equals('}'))
							{
								valid = false;
								break;
							}
							if (openingParentheses.equals('[') && !letter.equals(']'))
							{
								valid = false;
								break;
							}
						}
						catch (EmptyStackException e)
						{
							valid = false;
							break;
						}
					}
				}
				
				valid = valid && stack.isEmpty();

				System.out.println(valid ? "True" : "False");
			}
		}
	}
}