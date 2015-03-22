package org.ck.hackerRank.algorithms.warmup.acmIcpcTeam;

import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			Integer persons = in.nextInt();
			Integer topics = in.nextInt();
			in.nextLine();
			
			Boolean[][] personCapabilities = new Boolean[persons][topics];
			
			for (Integer i = 0; i < persons; ++i)
			{
				String person = in.nextLine();
				
				for (Integer j = 0; j < person.length(); ++j)
				{
					personCapabilities[i][j] = person.substring(j, j + 1).equals("1");
				}
			}
			
			Integer groupsThatCoverMax = 0;
			Integer maxTopicCount = 0;
			
			for (Integer i = 0; i < persons - 1; ++i)
			{
				for (Integer j = i + 1; j < persons; ++j)
				{
					Integer currentTopicCount = 0;
					
					for (Integer k = 0; k < topics; ++k)
					{
						if (personCapabilities[i][k] || personCapabilities[j][k])
						{
							++currentTopicCount;
						}
					}
					
					if (currentTopicCount > maxTopicCount)
					{
						groupsThatCoverMax = 1;
						maxTopicCount = currentTopicCount;
					}
					else if (currentTopicCount.equals(maxTopicCount))
					{
						groupsThatCoverMax++;
					}
				}
			}
			
			System.out.println(maxTopicCount);
			System.out.println(groupsThatCoverMax);
		}
	}
}