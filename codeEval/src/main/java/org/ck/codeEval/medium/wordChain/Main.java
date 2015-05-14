package org.ck.codeEval.medium.wordChain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 135, name = "Word chain", description = "Find the longest chain of words", url = "https://www.codeeval.com/open_challenges/135/", category = "Moderate challenges")
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
				String[] array = line.split(",");
				
				List<String> words = Arrays.asList(array);
				
				int length = getLength(null, words);

				System.out.println(length <= 1 ? "None" : length);
			}
		}
	}

	private static int getLength(String letter, List<String> words)
	{
		int length = 0;
		
		for (String word : words)
		{
			if (letter == null || word.startsWith(letter))
			{
				List<String> newWords = new ArrayList<>(words);
				newWords.remove(word);
				
				length = Math.max(length, 1 + getLength(word.substring(word.length() - 1), newWords));
			}
		}
			
		return length;
	}
}