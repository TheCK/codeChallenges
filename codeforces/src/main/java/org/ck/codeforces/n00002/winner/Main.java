package org.ck.codeforces.n00002.winner;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.*;

@Solution(
		id = 201,
		name = "A. Winner",
		url = "http://codeforces.com/problemset/problem/2/A",
		category = "2"
)
public class Main
{

	public static void main(String[] args) throws IOException
	{
		Map<String, Integer> pointsPerPlayer = new HashMap<>();
		List<SimpleEntry<String, Integer>> firstPlayerPerPoint = new ArrayList<>();

		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();
			in.nextLine();

			for (int i = 0; i < n; ++i)
			{
				String line = in.nextLine();
				String game[] = line.split(" ");

				String name = game[0];
				Integer points = Integer.valueOf(game[1]);

				pointsPerPlayer.computeIfAbsent(name, key -> 0);
				pointsPerPlayer.put(name, pointsPerPlayer.get(name) + points);

				SimpleEntry<String, Integer> pointsAtThisTime = new SimpleEntry<>(name, pointsPerPlayer.get(name));
				firstPlayerPerPoint.add(pointsAtThisTime);
			}

			List<String> candidates = new ArrayList<>();
			Integer maxPoints = 0;

			for (Map.Entry<String, Integer> entry : pointsPerPlayer.entrySet())
			{
				if (entry.getValue() > maxPoints)
				{
					maxPoints = entry.getValue();

					candidates = new ArrayList<>();
					candidates.add(entry.getKey());
				}
				else if (entry.getValue().equals(maxPoints))
				{
					candidates.add(entry.getKey());
				}
			}

			for (SimpleEntry<String, Integer> playerFirstAt : firstPlayerPerPoint)
			{
				if (candidates.contains(playerFirstAt.getKey()) && playerFirstAt.getValue() >= maxPoints)
				{
					System.out.println(playerFirstAt.getKey());
					return;
				}
			}
		}
	}
}