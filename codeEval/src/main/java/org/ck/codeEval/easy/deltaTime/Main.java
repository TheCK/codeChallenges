package org.ck.codeEval.easy.deltaTime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 166, name = "Delta Time", description = "Find the time difference.", url = "https://www.codeeval.com/open_challenges/166/", category = "Easy callenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] times = line.split(" ");

				DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
				Date date1 = formatter.parse(times[0]);
				
				Date date2 = formatter.parse(times[1]);
				
				long diff = date1.getTime() - date2.getTime();
				
				if (diff < 0)
				{
					diff *= -1;
				}
				
				Date result = new Date(diff);
				formatter = new SimpleDateFormat("HH:mm:ss");
				
				System.out.println(formatter.format(result));
			}
		}
	}
}