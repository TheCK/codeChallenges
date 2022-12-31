package org.ck.codeeval.easy.simpleortrump;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Solution(id = 235, name = "Simple or trump", description = "Check which card is higher.", url = "https://www.codeeval.com/open_challenges/325/", category = "Easy challenges")
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
				String[] argumentList = line.split("\\|");

				String[] cardList = argumentList[0].trim().split(" ");
				String trump = argumentList[1].trim();

				if (cardList[0].contains(trump) && !cardList[1].contains(trump))
				{
					System.out.println(cardList[0]);
				}
				else if (!cardList[0].contains(trump) && cardList[1].contains(trump))
				{
					System.out.println(cardList[1]);
				}
				else
				{
					for (String card : Arrays.asList("A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"))
					{
						if (cardList[0].contains(card) && !cardList[1].contains(card))
						{
							System.out.println(cardList[0]);
							break;
						}
						else if (!cardList[0].contains(card) && cardList[1].contains(card))
						{
							System.out.println(cardList[1]);
							break;
						}
						else if (cardList[0].contains(card) && cardList[1].contains(card))
						{
							System.out.println(cardList[0] + " " + cardList[1]);
							break;
						}
					}
				}
			}
		}
	}
}