package org.ck.codeEval.hard.uglynumers;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Solution(id = 42, name = "Ugly Numbers", description = "Count the number of expressions that can be created from a number", url = "https://www.codeeval.com/open_challenges/42/", category = "Hard challenges", solved = false)
public class Main
{
	private static List<Long> results;

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				results = new ArrayList<>();

				generateExpressions(line.substring(0, 1), line.substring(1));

				Long uglyNumbers = results.stream()
					.filter(Main::isUgly)
					.count();

				System.out.println(uglyNumbers);
			}
		}
	}

	private static boolean isUgly(Long number)
	{
		for (int prime : Arrays.asList(2, 3, 5, 7))
		{
			if ((number % prime) == 0)
			{
				return true;
			}
		}

		return false;
	}

	private static void generateExpressions(String expression, String remainingDigits)
	{
		if (remainingDigits.length() == 0)
		{
			evaluateExpression(expression);
			return;
		}

		String currentItem = remainingDigits.substring(0, 1);
		String newRemaining = remainingDigits.substring(1);

		long l = System.currentTimeMillis();
		generateExpressions(expression + currentItem, newRemaining);
		generateExpressions(expression + "+" + currentItem, newRemaining);
		generateExpressions(expression + "-" + currentItem, newRemaining);
		long l1 = System.currentTimeMillis() - l;
		if (l1 > 5)
			System.err.println(l1 + " " + expression);
	}

	private static void evaluateExpression(String expression)
	{
		List<Long> values = Arrays.stream(expression.split("[+-]")).map(string -> Long.valueOf(string)).collect(Collectors.toList());
		List<String> operations = Arrays.stream(expression.split("[\\d]+")).collect(Collectors.toList());

		if (operations.size() > 0)
		{
			operations.remove(0);
		}

		Long result = values.remove(0);

		while (operations.size() > 0)
		{
			String operation = operations.remove(0);
			Long value = values.remove(0);

			if ("+".equals(operation))
			{
				result += value;
			}
			else if ("-".equals(operation))
			{
				result -= value;
			}
		}

		results.add(result);
	}
}