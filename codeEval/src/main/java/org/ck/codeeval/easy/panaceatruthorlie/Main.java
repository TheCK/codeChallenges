package org.ck.codeeval.easy.panaceatruthorlie;

import org.ck.codechallengelib.annotation.Solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Solution(id = 237, name = "Panacea - truth or lie", description = "Check whether the virus was stopped by antivirus.", url = "https://www.codeeval.com/open_challenges/237/", category = "Easy challenges")
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
				String[] argumentLists = line.split("\\|");

				String hexNumbers = argumentLists[0].trim();
				String binNumbers = argumentLists[1].trim();

				int sumOfHexNumber = Arrays.stream(hexNumbers.split(" "))
					.mapToInt(hexNumber -> Integer.valueOf(hexNumber, 16))
					.sum();

				int sumOfBinNumbers = Arrays.stream(binNumbers.split(" "))
					.mapToInt(binNumber -> Integer.valueOf(binNumber, 2))
					.sum();

				System.out.println(sumOfHexNumber <= sumOfBinNumbers ? "True" : "False");
			}
		}
	}
}