package org.ck.codeeval.hard.telephoneWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 59, name = "Telephone Words", description = "Print out the words corresponding to a telephone number", url = "https://www.codeeval.com/open_challenges/59/", category = "Hard challenges")
public class Main
{
	private static Map<String, String[]> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception
	{
		map.put("0", new String[]{"0"});
		map.put("1", new String[]{"1"});
		map.put("2", new String[]{"a","b","c"});
		map.put("3", new String[]{"d","e","f"});
		map.put("4", new String[]{"g","h","i"});
		map.put("5", new String[]{"j","k","l"});
		map.put("6", new String[]{"m","n","o"});
		map.put("7", new String[]{"p","q","r","s"});
		map.put("8", new String[]{"t","u","v"});
		map.put("9", new String[]{"w","x","y","z"});
		
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				StringBuilder builder = new StringBuilder();
				printFirst(builder, line, line, "");
				
				builder.deleteCharAt(builder.length() - 1);
				System.out.println(builder);
			}
		}
	}

	private static void printFirst(StringBuilder builder, String original, String current, String sofar)
	{
		for (String letter : map.get(current.substring(0, 1)))
		{
			if(current.length() > 1)
			{
				printFirst(builder, original, current.substring(1), sofar + letter);
			}
			else
			{
				builder.append(sofar + letter + ",");
			}
		}
	}
}