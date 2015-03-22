package org.ck.codeEval.easy.swapElements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 112, name = "Swap Elements", description = "Swap elements in a list", url = "https://www.codeeval.com/open_challenges/112/", category = "Easy callenges")
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
				String[] arguments = line.split(":");

				String array = arguments[0].trim();
				String swapString =  arguments[1].trim();
				
				String[] numbers = array.split(" ");
				String[] swaps =  swapString.split(",");
				
				for (String swap : swaps)
				{
					String[] positions = swap.trim().split("-");
					Integer pos1 = Integer.valueOf(positions[0].trim());
					Integer pos2 = Integer.valueOf(positions[1].trim());
					
					String temp = numbers[pos1];
					numbers[pos1] = numbers[pos2];
					numbers[pos2] = temp;
				}
				
				StringBuilder builder = new StringBuilder();
				for (String number : numbers)
				{
					builder.append(number);
					builder.append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				
				System.out.println(builder);
			}
		}
	}
}
