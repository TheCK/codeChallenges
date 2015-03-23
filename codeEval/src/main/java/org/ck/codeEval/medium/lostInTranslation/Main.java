package org.ck.codeEval.medium.lostInTranslation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 121, name = "Lost In Translation", description = "Try to become a native speaker", url = "https://www.codeeval.com/open_challenges/121/", category = "Moderate callenges")
public class Main
{
	private static final Map<Character, Character> translation = new HashMap<>();
	
	public static void main(String[] args) throws Exception
	{
		initTranslation();
		
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < line.length(); ++i)
				{
					char letter = line.charAt(i);
					
					builder.append(translation.get(letter));
				}
				
				System.out.println(builder);
			}
		}
	}
	
	private static void initTranslation()
	{
		translation.put(' ', ' ');
		translation.put('a', 'y');
		translation.put('b', 'h');
		translation.put('c', 'e');
		translation.put('d', 's');
		translation.put('e', 'o');
		translation.put('f', 'c');
		translation.put('g', 'v');
		translation.put('h', 'x');
		translation.put('i', 'd');
		translation.put('j', 'u');
		translation.put('k', 'i');
		translation.put('l', 'g');
		translation.put('m', 'l');
		translation.put('n', 'b');
		translation.put('o', 'k');
		translation.put('p', 'r');
		translation.put('q', 'z');
		translation.put('r', 't');
		translation.put('s', 'n');
		translation.put('t', 'w');
		translation.put('u', 'j');
		translation.put('v', 'p');
		translation.put('w', 'f');
		translation.put('x', 'm');
		translation.put('y', 'a');
		translation.put('z', 'q');
	}
}