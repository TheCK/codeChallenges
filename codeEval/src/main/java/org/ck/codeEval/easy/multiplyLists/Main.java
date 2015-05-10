package org.ck.codeEval.easy.multiplyLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 113, name = "Multiply Lists", description = "Multiply elements in 2 lists", url = "https://www.codeeval.com/open_challenges/113/", category = "Easy challenges")
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
				String[] lists = line.split("\\|");
				
				Map<Integer, List<Integer>> multiplyLists = new HashMap<>();
				for (Integer i = 0; i < lists.length; ++i)
				{
					String[] numbers = lists[i].trim().split(" ");
					
					List<Integer> numList = new ArrayList<>();
					for (String number : numbers)
					{
						numList.add(Integer.valueOf(number));
					}
					
					multiplyLists.put(i, numList);
				}
				
				StringBuilder builder = new StringBuilder();
				for (Integer i = 0; i < multiplyLists.get(0).size(); ++i)
				{
					Integer mul = 1;
					
					for (Integer j = 0; j < multiplyLists.size(); ++j)
					{
						mul *= multiplyLists.get(j).get(i);
					}
					
					builder.append(mul);
					builder.append(" ");
				}
				builder.deleteCharAt(builder.length() - 1);
				
				System.out.println(builder);
			}	
		}
	}
}
