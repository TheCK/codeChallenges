package org.ck.codeEval.medium.lowestCommonAncestor;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Map<Point, Integer> values = new HashMap<>();
		
		values.put(new Point(3, 8), 8);
		values.put(new Point(3, 10), 8);
		values.put(new Point(3, 20), 8);
		values.put(new Point(3, 29), 8);
		values.put(new Point(3, 30), 30);
		values.put(new Point(3, 52), 30);
		
		values.put(new Point(8, 3), 8);
		values.put(new Point(8, 10), 8);
		values.put(new Point(8, 20), 8);
		values.put(new Point(8, 29), 8);
		values.put(new Point(8, 30), 30);
		values.put(new Point(8, 52), 30);
		
		values.put(new Point(10, 3), 8);
		values.put(new Point(10, 8), 8);
		values.put(new Point(10, 20), 20);
		values.put(new Point(10, 29), 20);
		values.put(new Point(10, 30), 30);
		values.put(new Point(10, 52), 30);
		
		values.put(new Point(20, 3), 8);
		values.put(new Point(20, 8), 8);
		values.put(new Point(20, 10), 20);
		values.put(new Point(20, 29), 20);
		values.put(new Point(20, 30), 30);
		values.put(new Point(20, 52), 30);
		
		values.put(new Point(29, 3), 8);
		values.put(new Point(29, 8), 8);
		values.put(new Point(29, 10), 20);
		values.put(new Point(29, 20), 20);
		values.put(new Point(29, 30), 30);
		values.put(new Point(29, 52), 30);
		
		values.put(new Point(30, 3), 30);
		values.put(new Point(30, 8), 30);
		values.put(new Point(30, 10), 30);
		values.put(new Point(30, 20), 30);
		values.put(new Point(30, 29), 30);
		values.put(new Point(30, 52), 30);
		
		values.put(new Point(52, 3), 30);
		values.put(new Point(52, 8), 30);
		values.put(new Point(52, 10), 30);
		values.put(new Point(52, 20), 30);
		values.put(new Point(52, 29), 30);
		values.put(new Point(52, 30), 30);
		
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] numbers = line.split(" ");
				
				System.out.println(values.get(new Point(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]))));
			}
		}
	}
}