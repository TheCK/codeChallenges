package org.ck.codeEval.medium.stringRotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codeChallengeLib.annotation.Solution;

@Solution(id = 76, name = "String Rotation", description = "Find if a string is the rotation of another string.", url = "https://www.codeeval.com/open_challenges/76/", category = "Moderate challenges")
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
				String[] array = line.split(",");
				
				String original = array[0];
				String rotation = array[1];
				
				Boolean matches = false;
				for (Integer i = 0; i < rotation.length(); ++i)
				{
					if(rotation.equals(original))
					{
						matches = true;
						break;
					}
					
					rotation = rotation.substring(1) + rotation.substring(0,  1);
				}
				
				System.out.println(matches ? "True" : "False");
			}
		}
	}
}