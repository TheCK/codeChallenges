package org.ck.codeeval.easy.bigdigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id=163, name="Big Digits", description="Print out magnified digits using pseudographics.", url="https://www.codeeval.com/open_challenges/163/", category="Easy challenges")
public class Main
{
	private static Map<String, String> line1Codes = new HashMap<>();
	private static Map<String, String> line2Codes = new HashMap<>();
	private static Map<String, String> line3Codes = new HashMap<>();
	private static Map<String, String> line4Codes = new HashMap<>();
	private static Map<String, String> line5Codes = new HashMap<>();
	private static String line6Code = "-----";
	
	public static void main(String[] args) throws IOException
	{
		setUpLines();
		
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				StringBuilder buffer1 = new StringBuilder();
				StringBuilder buffer2 = new StringBuilder();
				StringBuilder buffer3 = new StringBuilder();
				StringBuilder buffer4 = new StringBuilder();
				StringBuilder buffer5 = new StringBuilder();
				StringBuilder buffer6 = new StringBuilder();
				
				for (int i = 0; i < line.length(); ++i)
				{
					String pos = line.substring(i, i + 1);
					
					if(pos.matches("[0-9]"))
					{
						buffer1.append(line1Codes.get(pos));
						buffer2.append(line2Codes.get(pos));
						buffer3.append(line3Codes.get(pos));
						buffer4.append(line4Codes.get(pos));
						buffer5.append(line5Codes.get(pos));
						buffer6.append(line6Code);
					}
				}
				
				System.out.println(buffer1);
				System.out.println(buffer2);
				System.out.println(buffer3);
				System.out.println(buffer4);
				System.out.println(buffer5);
				System.out.println(buffer6);
			}
		}
	}

	private static void setUpLines()
	{
		line1Codes.put("1", "--*--");
		line1Codes.put("2", "***--");
		line1Codes.put("3", "***--");
		line1Codes.put("4", "-*---");
		line1Codes.put("5", "****-");
		line1Codes.put("6", "-**--");
		line1Codes.put("7", "****-");
		line1Codes.put("8", "-**--");
		line1Codes.put("9", "-**--");
		line1Codes.put("0", "-**--");
		
		line2Codes.put("1", "-**--");
		line2Codes.put("2", "---*-");
		line2Codes.put("3", "---*-");
		line2Codes.put("4", "*--*-");
		line2Codes.put("5", "*----");
		line2Codes.put("6", "*----");
		line2Codes.put("7", "---*-");
		line2Codes.put("8", "*--*-");
		line2Codes.put("9", "*--*-");
		line2Codes.put("0", "*--*-");
		
		line3Codes.put("1", "--*--");
		line3Codes.put("2", "-**--");
		line3Codes.put("3", "-**--");
		line3Codes.put("4", "****-");
		line3Codes.put("5", "***--");
		line3Codes.put("6", "***--");
		line3Codes.put("7", "--*--");
		line3Codes.put("8", "-**--");
		line3Codes.put("9", "-***-");
		line3Codes.put("0", "*--*-");
		
		line4Codes.put("1", "--*--");
		line4Codes.put("2", "*----");
		line4Codes.put("3", "---*-");
		line4Codes.put("4", "---*-");
		line4Codes.put("5", "---*-");
		line4Codes.put("6", "*--*-");
		line4Codes.put("7", "-*---");
		line4Codes.put("8", "*--*-");
		line4Codes.put("9", "---*-");
		line4Codes.put("0", "*--*-");
		
		line5Codes.put("1", "-***-");
		line5Codes.put("2", "****-");
		line5Codes.put("3", "***--");
		line5Codes.put("4", "---*-");
		line5Codes.put("5", "***--");
		line5Codes.put("6", "-**--");
		line5Codes.put("7", "-*---");
		line5Codes.put("8", "-**--");
		line5Codes.put("9", "-**--");
		line5Codes.put("0", "-**--");
	}
}
