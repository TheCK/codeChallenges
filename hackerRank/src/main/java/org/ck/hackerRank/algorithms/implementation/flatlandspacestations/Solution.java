package org.ck.hackerRank.algorithms.implementation.flatlandspacestations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10239,
		name = "Flatland Space Stations",
		url = "https://www.hackerrank.com/challenges/flatland-space-stations",
		category = "Algorithms",
		subCategory = "Implementation"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			int numberOfCities = in.nextInt();
			int numberOfStations = in.nextInt();

			List<Integer> citiesWithStations = new ArrayList<>();
			for (int i = 0; i < numberOfStations; ++i)
			{
				citiesWithStations.add(in.nextInt());
			}

			Collections.sort(citiesWithStations);

			int max = 0;
			for (int i = 0; i < numberOfStations - 1; ++i)
			{
				max = Math.max(max, (citiesWithStations.get(i + 1) - citiesWithStations.get(i)) / 2);
			}

			int distanceOf0 = citiesWithStations.stream().min(Integer::compareTo).get();
			max = Math.max(max, distanceOf0);

			int distanceOfN = citiesWithStations.stream().max(Integer::compareTo).get();
			max = Math.max(max, numberOfCities - 1 - distanceOfN);

			System.out.println(max);
		}
	}
}