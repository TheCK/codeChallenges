package org.ck.codeEval.medium.colorCodeConverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 148, name = "Color Code Converter", description = "Determine and convert the color code", url = "https://www.codeeval.com/open_challenges/148/", category = "Moderate callenges")
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

				String result;
				if (line.contains("HSL"))
				{
					result = convertFromHSL(line);
				}
				else if (line.contains("HSV"))
				{
					result = convertFromHSV(line);
				}
				else if (line.contains("#"))
				{
					result = convertFromHEX(line);
				}
				else
				{
					result = convertFromCMYK(line);
				}

				System.out.println(result);
			}
		}
	}

	private static String convertFromHSL(String line)
	{
		String[] values = line.substring(4, line.length() - 1).split(",");

		double hue = Double.parseDouble(values[0]);
		double saturation = Double.parseDouble(values[1]) / 100;
		double lightness = Double.parseDouble(values[2]) / 100;

		double chroma = (1 - Math.abs((2 * lightness) - 1)) * saturation;

		double huePrime = hue / 60;
		double x = chroma * (1 - Math.abs((huePrime % 2) - 1));

		double redPrime;
		double greenPrime;
		double bluePrime;

		if (0 <= huePrime && huePrime < 1)
		{
			redPrime = chroma;
			greenPrime = x;
			bluePrime = 0;
		}
		else if (1 <= huePrime && huePrime < 2)
		{
			redPrime = x;
			greenPrime = chroma;
			bluePrime = 0;
		}
		else if (2 <= huePrime && huePrime < 3)
		{
			redPrime = 0;
			greenPrime = chroma;
			bluePrime = x;
		}
		else if (3 <= huePrime && huePrime < 4)
		{
			redPrime = 0;
			greenPrime = x;
			bluePrime = chroma;
		}
		else if (4 <= huePrime && huePrime < 5)
		{
			redPrime = x;
			greenPrime = 0;
			bluePrime = chroma;
		}
		else
		{
			redPrime = chroma;
			greenPrime = 0;
			bluePrime = x;
		}

		double m = lightness - (chroma / 2);

		int red = (int) Math.round(255 * (redPrime + m));
		int green = (int) Math.round(255 * (greenPrime + m));
		int blue = (int) Math.round(255 * (bluePrime + m));

		return getRGBString(red, green, blue);
	}

	private static String convertFromHSV(String line)
	{
		String[] values = line.substring(4, line.length() - 1).split(",");

		double hue = Double.parseDouble(values[0]);
		double saturation = Double.parseDouble(values[1]) / 100;
		double value = Double.parseDouble(values[2]) / 100;

		double chroma = saturation * value;

		double huePrime = hue / 60;
		double x = chroma * (1 - Math.abs((huePrime % 2) - 1));

		double redPrime;
		double greenPrime;
		double bluePrime;

		if (0 <= huePrime && huePrime < 1)
		{
			redPrime = chroma;
			greenPrime = x;
			bluePrime = 0;
		}
		else if (1 <= huePrime && huePrime < 2)
		{
			redPrime = x;
			greenPrime = chroma;
			bluePrime = 0;
		}
		else if (2 <= huePrime && huePrime < 3)
		{
			redPrime = 0;
			greenPrime = chroma;
			bluePrime = x;
		}
		else if (3 <= huePrime && huePrime < 4)
		{
			redPrime = 0;
			greenPrime = x;
			bluePrime = chroma;
		}
		else if (4 <= huePrime && huePrime < 5)
		{
			redPrime = x;
			greenPrime = 0;
			bluePrime = chroma;
		}
		else
		{
			redPrime = chroma;
			greenPrime = 0;
			bluePrime = x;
		}

		double m = value - chroma;

		int red = (int) Math.round(255 * (redPrime + m));
		int green = (int) Math.round(255 * (greenPrime + m));
		int blue = (int) Math.round(255 * (bluePrime + m));

		return getRGBString(red, green, blue);
	}

	private static String convertFromHEX(String line)
	{
		int red = Integer.parseInt(line.substring(1, 3), 16);
		int green = Integer.parseInt(line.substring(3, 5), 16);
		int blue = Integer.parseInt(line.substring(5, 7), 16);

		return getRGBString(red, green, blue);
	}

	private static String convertFromCMYK(String line)
	{
		String[] values = line.substring(1, line.length() - 1).split(",");

		double cyan = Double.parseDouble(values[0]);
		double magenta = Double.parseDouble(values[1]);
		double yellow = Double.parseDouble(values[2]);
		double black = Double.parseDouble(values[3]);

		int red = (int) Math.round(255 * (1 - cyan) * (1 - black));
		int green = (int) Math.round(255 * (1 - magenta) * (1 - black));
		int blue = (int) Math.round(255 * (1 - yellow) * (1 - black));

		return getRGBString(red, green, blue);
	}

	private static String getRGBString(int red, int green, int blue)
	{
		return String.format("RGB(%d,%d,%d)", red, green, blue);
	}
}