package org.ck.codeeval.easy.setIntersection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 30, name = "Set Intersection", description = "Print the intersection of two sets of numbers.", url = "https://www.codeeval.com/open_challenges/30/", category = "Easy challenges")
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
				String[] stringSets = line.split(";");
				String[] stringSet1 = stringSets[0].split(",");
				String[] stringSet2 = stringSets[1].split(",");

				Set<Integer> set1 = getRealSet(stringSet1);
				Set<Integer> set2 = getRealSet(stringSet2);
				
				set1.retainAll(set2);
				
				StringBuilder builder = new StringBuilder();
				for (Integer number : set1)
				{
					builder.append(number);
					builder.append(",");
				}
				if (builder.length() > 1)
				{
					builder.deleteCharAt(builder.length() - 1);
				}
				
				System.out.println(builder);
			}
		}
	}

	private static Set<Integer> getRealSet(String[] stringSet1)
	{
		Set<Integer> set = new TreeSet<>();
		
		for (String number : stringSet1)
		{
			set.add(Integer.valueOf(number));
		}
		
		return set;
	}
}
