package org.ck.codeforces.spreadsheets;

import org.ck.codeChallengeLib.annotation.Solution;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
		id = 102,
		name = "B. Spreadsheets",
		url = "http://codeforces.com/problemset/problem/1/B",
		category = "1"
)
public class Main
{
	private static final Pattern rowColumnPattern = Pattern.compile("R([0-9]+)C([0-9]+)");
	private static final Pattern letterColumnPattern = Pattern.compile("([A-Z]+)([0-9]+)");

	public static void main(String[] args) throws IOException
	{
		try (Scanner in = new Scanner(System.in))
		{
			int n = in.nextInt();
			in.nextLine();

			for (int i = 0; i < n; ++i)
			{
				String value = in.nextLine();

				Matcher rowColumnMatcher = rowColumnPattern.matcher(value);
				Matcher letterColumnMatcher = letterColumnPattern.matcher(value);

				if (rowColumnMatcher.matches())
				{
					long row = Long.parseLong(rowColumnMatcher.group(1));
					long column = Long.parseLong(rowColumnMatcher.group(2));

					String columnString = "";
					while (column > 0)
					{
						int additional = 0;
						if (column % 26 == 0)
						{
							--column;
							additional = 1;
						}

						char letter = (char) ('@' + (char) (column % 26) + additional);

						columnString = new Character(letter) + columnString;
						column /= 26;
					}

					System.out.println(columnString + row);
				}
				else if (letterColumnMatcher.matches())
				{
					String columnString = letterColumnMatcher.group(1);
					long row = Long.parseLong(letterColumnMatcher.group(2));

					long column = 0;
					while (columnString.length() > 0)
					{
						column += Math.pow(26, columnString.length() - 1) * (columnString.charAt(0) - '@');

						columnString = columnString.substring(1);
					}

					System.out.println(String.format("R%dC%d", row, column));
				}
			}
		}
	}
}