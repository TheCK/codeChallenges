package org.ck.codeEval.easy.niceAngles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 160, name = "Nice angles", description = "Convert angle values to sexagesimal format.", url = "https://www.codeeval.com/open_challenges/160/", category = "Easy callenges")
public class Main
{
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				Float angle = Float.valueOf(line);
				
				Float remainder = angle - angle.intValue();
				Float minutes = remainder * 60;
				
				remainder = minutes - minutes.intValue();
				Float seconds = remainder * 60;
				
				System.out.println(String.format("%d.%02d'%02d\"", angle.intValue(), minutes.intValue(), seconds.intValue()));
			}
		}
	}
}
