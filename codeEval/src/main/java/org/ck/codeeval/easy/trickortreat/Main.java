package org.ck.codeeval.easy.trickortreat;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Solution(id=220, name="Trick or Treat", description="Count all candies.", url="https://www.codeeval.com/open_challenges/220/", category="Easy challenges")
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
				String[] arguments = line.split(",");

				int vampires = 0;
				int zombies = 0;
				int witches = 0;

				int houses = 0;

				for (String argument : arguments)
				{
					String[] parameter = argument.trim().split(":");

					int currentNumber = Integer.parseInt(parameter[1].trim());

					switch (parameter[0])
					{
						case "Vampires":
							vampires = currentNumber;
							break;
						case "Zombies":
							zombies = currentNumber;
							break;
						case "Witches":
							witches = currentNumber;
							break;
						case "Houses":
							houses = currentNumber;
							break;
						default:
							break;
					}
				}

				int kids = vampires + zombies + witches;
				int sweets = houses * (vampires * 3 + zombies * 4 + witches * 5);

				System.out.println(kids == 0 ? 0 : sweets / kids);
			}
		}
	}
}