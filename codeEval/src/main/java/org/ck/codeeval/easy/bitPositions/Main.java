package org.ck.codeeval.easy.bitPositions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 19, name = "Bit Positions", description = "Bits in position x,y are same or different.", url = "https://www.codeeval.com/open_challenges/19/", category = "Easy challenges")
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
				String[] numbers = line.split(",");

				Integer number = Integer.parseInt(numbers[0]);
				Integer bit1 = Integer.parseInt(numbers[1]);
				Integer bit2 = Integer.parseInt(numbers[2]);

				String bits = Integer.toBinaryString(number);
				
				System.out.println(bits.charAt(bits.length() - bit1) == bits.charAt(bits.length() - bit2));
			}
		}
	}
}
