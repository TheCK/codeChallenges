package org.ck.codeEval.medium.overlappingRectangles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 70, name = "Overlapping Rectangles", description = "Determine if two rectangles overlap.", url = "https://www.codeeval.com/open_challenges/70/", category = "Moderate callenges")
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
				String[] arguments = line.split(",");

				Integer topLeftX1 = Integer.valueOf(arguments[0]);
				Integer topLeftY1 = Integer.valueOf(arguments[1]);
				Integer lowerRightX1 = Integer.valueOf(arguments[2]);
				Integer lowerRightY1 = Integer.valueOf(arguments[3]);
				
				Integer topLeftX2 = Integer.valueOf(arguments[4]);
				Integer topLeftY2 = Integer.valueOf(arguments[5]);
				Integer lowerRightX2 = Integer.valueOf(arguments[6]);
				Integer lowerRightY2 = Integer.valueOf(arguments[7]);

				Boolean intersects = false;
				if (topLeftX1 <= topLeftX2 && topLeftX2 <= lowerRightX1 && lowerRightY1 <= topLeftY2 && topLeftY2 <= topLeftY1)
				{
					intersects = true;
				}
				if (topLeftX1 <= topLeftX2 && topLeftX2 <= lowerRightX1 && lowerRightY1 <= lowerRightY2 && lowerRightY2 <= topLeftY1)
				{
					intersects = true;
				}
				if (topLeftX1 <= lowerRightX2 && lowerRightX2 <= lowerRightX1 && lowerRightY1 <= lowerRightY2 && lowerRightY2 <= topLeftY1)
				{
					intersects = true;
				}
				if (topLeftX1 <= lowerRightX2 && lowerRightX2 <= lowerRightX1 && lowerRightY1 <= topLeftY2 && topLeftY2 <= topLeftY1)
				{
					intersects = true;
				}
				
				if (topLeftX2 <= topLeftX1 && topLeftX1 <= lowerRightX2 && lowerRightY2 <= topLeftY1 && topLeftY1 <= topLeftY2)
				{
					intersects = true;
				}
				if (topLeftX2 <= topLeftX1 && topLeftX1 <= lowerRightX2 && lowerRightY2 <= lowerRightY1 && lowerRightY1 <= topLeftY2)
				{
					intersects = true;
				}
				if (topLeftX2 <= lowerRightX1 && lowerRightX1 <= lowerRightX2 && lowerRightY2 <= lowerRightY1 && lowerRightY1 <= topLeftY2)
				{
					intersects = true;
				}
				if (topLeftX2 <= lowerRightX1 && lowerRightX1 <= lowerRightX2 && lowerRightY2 <= topLeftY1 && topLeftY1 <= topLeftY2)
				{
					intersects = true;
				}
					
				System.out.println(intersects ? "True" : "False");
			}
		}
	}
}