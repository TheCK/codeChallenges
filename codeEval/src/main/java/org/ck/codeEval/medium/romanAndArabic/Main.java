package org.ck.codeEval.medium.romanAndArabic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 150, name = "Roman and Arabic", description = "Calculate aromatic numbers.", url = "https://www.codeeval.com/open_challenges/150/", category = "Moderate callenges")
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

				List<Number> numbers = new ArrayList<>();
				for (int i = 0; i < line.length(); i += 2)
				{
					numbers.add(new Number(line.substring(i, i + 2)));
				}
				
				int sum = 0;
				for (int i = 0; i < numbers.size(); ++i)
				{
					if (i < numbers.size() - 1)
					{
						if (numbers.get(i).compareTo(numbers.get(i + 1)) < 0)
						{
							sum -= numbers.get(i).getValue();
						}
						else
						{
							sum += numbers.get(i).getValue();
						}
					}
					else
					{
						sum += numbers.get(i).getValue();
					}
				}
				
				System.out.println(sum);
			}
		}
	}
	
	private static class Number implements Comparable<Number>
	{
		private int count;
		private Numeral numeral;
		
		public Number (String string)
		{
			this.count = Integer.parseInt(string.substring(0, 1));
			this.numeral = Numeral.valueOf(string.substring(1, 2));
		}
		
		public int getValue()
		{
			return this.count * this.numeral.getValue();
		}

		@Override
		public int compareTo(Number otherNumber)
		{
			return this.numeral.compareTo(otherNumber.numeral);
		}
	}
	
	private static enum Numeral
	{
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
		
		private int value;
		
		private Numeral(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return this.value;
		}
	}
}