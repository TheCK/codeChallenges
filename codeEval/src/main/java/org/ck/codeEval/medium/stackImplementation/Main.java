package org.ck.codeEval.medium.stackImplementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 9, name = "Stack Implementation", description = "Implement a stack interface", url = "https://www.codeeval.com/open_challenges/9/", category = "Moderate callenges")
public class Main
{
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] numbers = line.split(" ");

				for (String number : numbers)
				{
					push(Integer.valueOf(number));
				}
				
				StringBuilder builder = new StringBuilder();
				while (!stack.empty())
				{
					builder.append(pop() + " ");
					if (!stack.empty())
					{
						pop();
					}
				}
				
				if(builder.length() > 0)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				System.out.println(builder);
			}
		}
	}

	public static void push(Integer number)
	{
		stack.push(number);
	}
	
	public static Integer pop()
	{
		return stack.pop();
	}
}