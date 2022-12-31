package org.ck.codeeval.easy.compressedsequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 128, name = "Compressed Sequence", description = "Write a program that compresses a sequence of numbers", url = "https://www.codeeval.com/open_challenges/128/", category = "Easy challenges")
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
				String[] numbers = line.split(" ");
				
				List<String> nums = new ArrayList<>();
				List<Integer> counts = new ArrayList<>();
				for (String number : numbers)
				{
					if (nums.size() > 0 && number.equals(nums.get(nums.size() - 1)))
					{
						counts.set(counts.size() - 1, counts.get(counts.size() - 1) + 1);
					}
					else
					{
						nums.add(number);
						counts.add(1);
					}
				}
				
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < nums.size(); ++i)
				{
					builder.append(counts.get(i));
					builder.append(" ");
					builder.append(nums.get(i));
					builder.append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				
				System.out.println(builder);
			}
		}
	}
}
