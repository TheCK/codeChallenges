package org.ck.codeeval.medium.gronsfeldCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 181, name = "Gronsfeld cipher", description = "Decipher the message enciphered with the Gronsfeld cipher.", url = "https://www.codeeval.com/open_challenges/181/", category = "Moderate challenges")
public class Main
{
	private static final String alphabet = " !\"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
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
				
				String code = arguments[0];
				String cypher = arguments[1];
				
				int codeIndex = 0;
				int cypherIndex = 0;
				
				StringBuilder builder = new StringBuilder();
				while (cypherIndex < cypher.length())
				{
					int shift = Integer.parseInt(code.substring(codeIndex, codeIndex + 1));
					String cypherChar = cypher.substring(cypherIndex, cypherIndex + 1);
					
					int alphabetPos = alphabet.indexOf(cypherChar);
					
					if (alphabetPos >= shift)
					{
						builder.append(alphabet.substring(alphabetPos - shift, alphabetPos - shift + 1));
					}
					else
					{
						builder.append(alphabet.substring(alphabet.length() - (shift - alphabetPos), alphabet.length() - (shift - alphabetPos) + 1));
					}
					
					++cypherIndex;
					++codeIndex;
					
					if (codeIndex == code.length())
					{
						codeIndex = 0;
					}
				}
				
				System.out.println(builder);
			}
		}
	}
}