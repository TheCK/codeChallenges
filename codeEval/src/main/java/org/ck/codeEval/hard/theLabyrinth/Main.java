package org.ck.codeEval.hard.theLabyrinth;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 157, name = "The Labyrinth", description = "Find the shortest way to exit.", url = "https://www.codeeval.com/open_challenges/157/", category = "Hard callenges", solved = false)
public class Main
{
	private static int shortest = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception
	{
		shortest = Integer.MAX_VALUE;
		
		List<String> lines = new ArrayList<>();

		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				lines.add(line);
			}
		}

		String[][] field = new String[lines.size()][lines.get(0).length()];
		boolean[][] bField = new boolean[lines.size()][lines.get(0).length()];

		for (int i = 0; i < lines.size(); ++i)
		{
			for (int j = 0; j < lines.get(i).length(); ++j)
			{
				field[i][j] = lines.get(i).substring(j, j + 1);
				bField[i][j] = lines.get(i).substring(j, j + 1).equals(" ");
			}
		}

		List<Point> path =	go(bField, new ArrayList<Point>(), lines.size() - 1, lines.get(0).length() - 1, 0, lines.get(0).indexOf(" "));

		for (Point point : path)
		{
			field[point.x][point.y] = "+";
		}

		printField(field);
	}

	private static List<Point> go(boolean[][] field, List<Point> path, int maxX, int maxY, int x, int y)
	{
		Point point = new Point(x, y);

		if (x == maxX && field[x][y])
		{
			path.add(point);
			
			if (path.size() < shortest)
			{
				shortest = path.size();
			}

			return path;
		}

		if (!field[x][y] || path.contains(point))
		{
			return null;
		}

		path.add(new Point(x, y));
		
		if (path.size() > shortest)
		{
			return null;
		}

		List<Point> returnPath = null;
		if (x > 0)
		{
			List<Point> newPath = go(field, new ArrayList<>(path), maxX, maxY, x - 1, y);
			if (newPath != null)
			{
				returnPath = newPath;
			}
		}
		if (x < maxX)
		{
			List<Point> newPath = go(field, new ArrayList<>(path), maxX, maxY, x + 1, y);
			if (newPath != null && (returnPath == null || returnPath.size() > newPath.size()))
			{
				returnPath = newPath;
			}
		}
		if (y > 0)
		{
			List<Point> newPath = go(field, new ArrayList<>(path), maxX, maxY, x, y - 1);
			if (newPath != null && (returnPath == null || returnPath.size() > newPath.size()))
			{
				returnPath = newPath;
			}
		}
		if (y < maxY)
		{
			List<Point> newPath = go(field, new ArrayList<>(path), maxX, maxY, x, y + 1);
			if (newPath != null && (returnPath == null || returnPath.size() > newPath.size()))
			{
				returnPath = newPath;
			}
		}

		return returnPath;
	}

	public static void printField(String[][] field)
	{
		for (String[] line : field)
		{
			for (String box : line)
			{
				System.out.print(box);
			}
			
			System.out.println("");
		}
	}
}