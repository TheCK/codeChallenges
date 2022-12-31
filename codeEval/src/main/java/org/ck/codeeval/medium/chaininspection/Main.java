package org.ck.codeeval.medium.chaininspection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 119, name = "Chain Inspection", description = "Try to pass a chain", url = "https://www.codeeval.com/open_challenges/119/", category = "Moderate challenges")
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
				String[] pairs = line.split(";");

				Map<String, String> values = new HashMap<>();

				for (String pair : pairs)
				{
					String[] nodes = pair.split("-");
					
					values.put(nodes[0], nodes[1]);
				}
				
				Integer count = 0;
				String current = "BEGIN";

				while (!current.equals("END"))
				{
					current = values.get(current);
					++count;
					
					if (count > values.size())
					{
						break;
					}
				}

				System.out.println(count ==  values.size() ? "GOOD" : "BAD");
			}
		}
	}
}