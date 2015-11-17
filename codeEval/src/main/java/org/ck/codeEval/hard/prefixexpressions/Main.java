package org.ck.codeEval.hard.prefixexpressions;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Stack;

@Solution(id = 7, name = "Prefix expressions", description = "Evaluating a prefix expression.", url = "https://www.codeeval.com/open_challenges/7/", category = "Hard challenges")
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
				String[] arguments = line.split(" ");

				Stack<String> operators = new Stack<>();
				LinkedList<Double> operands = new LinkedList<>();

				for (int i = 0; i < arguments.length; ++i)
				{
					String argument = arguments[i];

					if (argument.equals("+") || argument.equals("*") || argument.equals("/"))
					{
						operators.push(argument);
					}
					else
					{
						operands.add(Double.valueOf(argument));
					}
				}

				while (operands.size() > 1)
				{
					Double operand1 = operands.removeFirst();
					Double operand2 = operands.removeFirst();

					Double result = 0D;

					switch (operators.pop())
					{
						case "+":
							result = operand1 + operand2;
							break;
						case "*":
							result = operand1 * operand2;
							break;
						case "/":
							result = operand1 / operand2;
							break;
					}

					operands.push(result);
				}

				System.out.println((int) (double) operands.pop());
			}
		}
	}
}