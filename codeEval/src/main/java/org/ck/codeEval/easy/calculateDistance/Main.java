package org.ck.codeEval.easy.calculateDistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 99, name = "Calculate Distance", description = "Calculate a distance between two points", url = "https://www.codeeval.com/open_challenges/99/", category = "Easy callenges")
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

				Pattern p = Pattern.compile("(\\-?\\d+)");
				Matcher m = p.matcher(line);

				int x1 = 0;
				if (m.find())
				{
					x1 = Integer.valueOf(m.group());
				}
				
				int y1 = 0;
				if (m.find())
				{
					y1 = Integer.valueOf(m.group());
				}
				
				int x2 = 0;
				if (m.find())
				{
					x2 = Integer.valueOf(m.group());
				}
				
				int y2 = 0;
				if (m.find())
				{
					y2 = Integer.valueOf(m.group());
				}
				
				int xdist = x1 - x2;
				int ydist = y1 - y2;
				
				System.out.println((int) Math.sqrt((xdist * xdist) + (ydist * ydist)));
			}
		}
	}
}
