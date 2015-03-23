package org.ck.codeEval.medium.locks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 153, name = "Locks", description = "Calculate unlocked doors.", url = "https://www.codeeval.com/open_challenges/153/", category = "Moderate callenges")
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
				String[] values = line.split(" ");
				
				int locks = Integer.parseInt(values[0]);
				int iterations = Integer.parseInt(values[1]);
				
				boolean[] locked = new boolean[locks];
				
				for (int i = 0; i < iterations - 1; ++i)
				{
					for (int j = 1; j < locks; j += 2)
					{
						locked[j] = true;
					}
					for (int j = 2; j < locks; j += 3)
					{
						locked[j] = !locked[j];
					}
				}
				
				locked[locks - 1] = !locked[locks - 1];
				
				int count = 0;
				for (boolean isCurrentLocked : locked)
				{
					if (!isCurrentLocked)
					{
						++count;
					}
				}
				
				System.out.println(count);
			}
		}
	}
}