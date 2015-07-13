package org.ck.codeEval.hard.textDollar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 52, name = "Text Dollar", description = "Print out the text dollar amount of a given quantity", url = "https://www.codeeval.com/open_challenges/52/", category = "Hard challenges")
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

				if (line.equals("0"))
				{
					System.out.println("ZeroDollars");
				}
				else
				{
					boolean weird = false;

					StringBuilder builder = new StringBuilder();

					while (line.length() != 0)
					{
						int digit = Integer.parseInt(line.substring(0, 1));
						int place = line.length();

						String string = getString(digit, place, weird, builder.toString());

						if (string != null)
						{
							builder.append(string);
							weird = false;
						}
						else
						{
							weird = true;
						}

						line = line.substring(1);
					}

					System.out.println(builder);
				}
			}
		}
	}

	private static String getString(int digit, int place, boolean weird, String soFar)
	{
		switch (place)
		{
			case 2:
			case 5:
			case 8:
				return getTens(digit);
			case 3:
			case 6:
			case 9:
				return getHundreds(digit);
			case 1:
				return getOnes(digit, weird) + "Dollars";
			case 4:
				String thousands = getOnes(digit, weird);

				if (thousands.length() != 0 || !soFar.endsWith("Million"))
				{
					thousands += "Thousand";
				}
				
				return thousands;
			case 7:
				String millions = getOnes(digit, weird);

				if (millions.length() != 0 || soFar.length() != 0)
				{
					millions += "Million";
				}
				
				return millions;
			default:
				throw new RuntimeException();
		}
	}

	private static String getHundreds(int digit)
	{
		if (digit == 0)
		{
			return "";
		}
		
		return getOnes(digit, false) + "Hundred";
	}

	private static String getTens(int digit)
	{
		switch (digit)
		{
			case 0:
				return "";
			case 1:
				return null;
			case 2:
				return "Twenty";
			case 3:
				return "Thirty";
			case 4:
				return "Forty";
			case 5:
				return "Fifty";
			case 6:
				return "Sixty";
			case 7:
				return "Seventy";
			case 8:
				return "Eighty";
			case 9:
				return "Ninety";
			default:
				throw new RuntimeException();
		}
	}

	private static String getOnes(int digit, boolean weird)
	{
		if (weird)
		{
			switch (digit)
			{
				case 0:
					return "Ten";
				case 1:
					return "Eleven";
				case 2:
					return "Twelve";
				case 3:
					return "Thirteen";
				case 4:
					return "Fourteen";
				case 5:
					return "Fifteen";
				case 6:
					return "Sixteen";
				case 7:
					return "Seventeen";
				case 8:
					return "Eighteen";
				case 9:
					return "Nineteen";
				default:
					throw new RuntimeException();
			}
		}

		switch (digit)
		{
			case 0:
				return "";
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			default:
				throw new RuntimeException();
		}
	}
}