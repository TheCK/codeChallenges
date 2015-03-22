package org.ck.codeEval.medium.brokenLCD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 179, name = "Broken LCD", description = "Determine whether a given number can be displayed on the damaged LCD.", url = "https://www.codeeval.com/open_challenges/179/", category = "Moderate callenges")
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
				String[] arguments = line.split(";");

				String[] display = arguments[0].split(" ");
				String number = arguments[1];

				byte[] status = new byte[12];

				for (Integer i = 0; i < 12; ++i)
				{
					status[i] = (byte) Integer.parseInt(display[i], 2);
				}

				Integer digits = number.length();

				if (number.contains("."))
				{
					digits--;
				}

				boolean displayable = false;
				for (Integer i = 0; i < 13 - digits; ++i)
				{
					//System.out.println("Starting at: " + i);

					boolean displayableFromI = true;

					Integer j = 0;
					for (Integer k = 0; k < number.length(); ++k)
					{
						String digit = number.substring(k, k + 1);
						boolean withPoint = false;

						if (digit.equals("."))
						{
							continue;
						}

						if (k + 1 < number.length())
						{
							withPoint = number.substring(k + 1, k + 2).equals(".");
						}

						//System.out.println("Can " + digit + " ( " + Integer.toBinaryString(getDigitCode(digit, withPoint)) + " ) display on " + Integer.toBinaryString(status[i + j]));

						displayableFromI = displayableFromI && (getDigitCode(digit, withPoint) == (status[i + j] & getDigitCode(digit, withPoint)));
						//System.out.println(displayableFromI);

						if (!displayableFromI)
						{
							break;
						}

						++j;
					}

					if (displayableFromI)
					{
						displayable = true;
						break;
					}

					//System.out.println("");
				}

				System.out.println(displayable ? 1 : 0);
			}
		}
	}

	private static byte getDigitCode(String digit, boolean withPoint)
	{
		byte code = 0;

		if (digit.equals("0"))
		{
			code = (byte) Integer.parseInt("11111100", 2);
		}
		else if (digit.equals("1"))
		{
			code = (byte) Integer.parseInt("01100000", 2);
		}
		else if (digit.equals("2"))
		{
			code = (byte) Integer.parseInt("11011010", 2);
		}
		else if (digit.equals("3"))
		{
			code = (byte) Integer.parseInt("11110010", 2);
		}
		else if (digit.equals("4"))
		{
			code = (byte) Integer.parseInt("01100110", 2);
		}
		else if (digit.equals("5"))
		{
			code = (byte) Integer.parseInt("10110110", 2);
		}
		else if (digit.equals("6"))
		{
			code = (byte) Integer.parseInt("10111110", 2);
		}
		else if (digit.equals("7"))
		{
			code = (byte) Integer.parseInt("11100000", 2);
		}
		else if (digit.equals("8"))
		{
			code = (byte) Integer.parseInt("11111110", 2);
		}
		else if (digit.equals("9"))
		{
			code = (byte) Integer.parseInt("11110110", 2);
		}

		if (withPoint)
		{
			code = (byte) (code | ((byte) 1));
		}

		return code;
	}
}