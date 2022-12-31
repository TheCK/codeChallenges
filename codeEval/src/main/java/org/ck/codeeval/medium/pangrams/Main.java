package org.ck.codeeval.medium.pangrams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 37, name = "Pangrams", description = "Find the missing alphabets", url = "https://www.codeeval.com/open_challenges/37/", category = "Moderate challenges")
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
				
				Set<String> alphabet = new TreeSet<>(Arrays.asList(new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}));
				Set<String> letters = new TreeSet<>();
				
				for (int i = 0; i < line.length(); ++i)
				{
					letters.add(line.substring(i, i + 1).toLowerCase());
				}
				
				alphabet.removeAll(letters);
				
				if (alphabet.size() == 0)
				{
					System.out.print("NULL");
				}
				else
				{
					for (String letter : alphabet)
					{
						System.out.print(letter);
					}
				}
				
				System.out.println("");
			}
		}
	}
}