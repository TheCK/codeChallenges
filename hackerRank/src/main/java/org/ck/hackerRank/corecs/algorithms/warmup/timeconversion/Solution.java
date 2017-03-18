package org.ck.hackerRank.corecs.algorithms.warmup.timeconversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10109,
		name = "Time Conversion",
		url = "https://www.hackerrank.com/challenges/time-conversion",
		category = "Algorithms",
		subCategory = "Warmup"
)
public class Solution
{
	private static final SimpleDateFormat oldFormat = new SimpleDateFormat("hh:mm:ssa", Locale.US);
	private static final SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);

	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			String time = in.next("[0-9]{2}:[0-9]{2}:[0-9]{2}[AP]M");

			try
			{
				Date date = oldFormat.parse(time);

				System.out.println(newFormat.format(date));
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
	}
}