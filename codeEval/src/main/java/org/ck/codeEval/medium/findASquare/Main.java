package org.ck.codeEval.medium.findASquare;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 101, name = "Find a Square", description = "Do 4 points make a square?", url = "https://www.codeeval.com/open_challenges/101/", category = "Moderate callenges")
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
				String[] pointsString = line.split(", ");
				
				List<Point> points = new ArrayList<>();
				for (String pointString : pointsString)
				{
					String[] point = pointString.trim().replaceAll("[\\(\\)]", "").split(",");
					
					points.add(new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
				}

				Set<Double> distances = new HashSet<>();
				for (int i = 0; i < points.size() - 1; ++i)
				{
					for (int j = i + 1; j < points.size(); ++j)
					{
						distances.add(points.get(i).distance(points.get(j)));
					}
				}
				
				System.out.println(distances.size() == 2);
			}
		}
	}
}