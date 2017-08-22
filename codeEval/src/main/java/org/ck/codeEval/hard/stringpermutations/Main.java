package org.ck.codeEval.hard.stringpermutations;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Solution(id = 14, name = "String Permutations", description = "Print out all permutations of a string.", url = "https://www.codeeval.com/open_challenges/14/", category = "Hard challenges")
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

				List<String> permutations = getPermutation(line);
				Collections.sort(permutations);

				System.out.println(permutations.stream().collect(Collectors.joining(",")));
			}
		}
	}

	private static List<String> getPermutation(String letters)
	{
		if (letters.length() == 0)
		{
			return Arrays.asList("");
		}

		List<String> permuations = new ArrayList<>();

		for (String letter : letters.split(""))
		{
			List<String> furtherPermuations = getPermutation(letters.replace(letter, ""));

			for (String furtherPermutation : furtherPermuations)
			{
				permuations.add(letter + furtherPermutation);
			}
		}

		return permuations;
	}
}