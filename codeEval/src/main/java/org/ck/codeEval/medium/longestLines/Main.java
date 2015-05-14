package org.ck.codeEval.medium.longestLines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 2, name = "Longest Lines", description = "Finding the 'N' longest lines within a file.", url = "https://www.codeeval.com/open_challenges/2/", category = "Moderate challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		(new Main()).doStuff(args);
	}

	private void doStuff(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			
			Integer count = 0;
			if ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				count = Integer.valueOf(line);
			}
			
			Set<Line> lines = new TreeSet<>();
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				
				lines.add(new Line(line));
			}
			
			for (Line lineObject : lines)
			{
				System.out.println(lineObject.getText());
				
				if (--count == 0)
				{
					break;
				}
			}
		}
	}
	
	private class Line implements Comparable<Line>
	{
		private String text;
		
		public Line(String text)
		{
			this.text = text;
		}
		
		public String getText()
		{
			return this.text;
		}
		
		@Override
		public int compareTo(Line o)
		{
			return -1 * (new Integer(this.text.length())).compareTo(o.getText().length());
		}
	}
}