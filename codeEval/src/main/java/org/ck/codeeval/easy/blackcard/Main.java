package org.ck.codeeval.easy.blackcard;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Solution(id=222, name="Black card", description="Find the winner.", url="https://www.codeeval.com/open_challenges/222/", category="Easy challenges")
public class Main
{
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] arguments = line.split("\\|");

				List<String> players = new ArrayList<>(Arrays.asList(arguments[0].trim().split(" ")));
				int number = Integer.parseInt(arguments[1].trim()) - 1;

				while (players.size() > 1)
				{
					players.remove(number % players.size());
				}

				System.out.println(players.get(0));
			}
		}
	}
}