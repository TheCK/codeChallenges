package org.ck.codeeval.easy.morseCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 116, name = "Morse Code", description = "Decode Morse code", url = "https://www.codeeval.com/open_challenges/116/", category = "Easy challenges")
public class Main
{
	private static Map<String, String> morseCode = new HashMap<>();
	
	public static void main(String[] args) throws IOException
	{
		setUpTable();
		
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();
				String[] letters = line.split(" ");

				StringBuilder builder = new StringBuilder();
				for (String letter : letters)
				{
					if (letter.equals(""))
					{
						builder.append(" ");
					}
					else
					{
						builder.append(morseCode.get(letter));
					}
				}
				
				System.out.println(builder);
			}
		}
	}

	private static void setUpTable()
	{
		morseCode.put(".-", "A");
		morseCode.put("-...", "B");
		morseCode.put("-.-.", "C");
		morseCode.put("-..", "D");
		morseCode.put(".", "E");
		morseCode.put("..-.", "F");
		morseCode.put("--.", "G");
		morseCode.put("....", "H");
		morseCode.put("..", "I");
		morseCode.put(".---", "J");
		morseCode.put("-.-", "K");
		morseCode.put(".-..", "L");
		morseCode.put("--", "M");
		morseCode.put("-.", "N");
		morseCode.put("---", "O");
		morseCode.put(".--.", "P");
		morseCode.put("--.-", "Q");
		morseCode.put(".-.", "R");
		morseCode.put("...", "S");
		morseCode.put("-", "T");
		morseCode.put("..-", "U");
		morseCode.put("...-", "V");
		morseCode.put(".--", "W");
		morseCode.put("-..-", "X");
		morseCode.put("-.--", "Y");
		morseCode.put("--..", "Z");
		morseCode.put("-----", "0");
		morseCode.put(".----", "1");
		morseCode.put("..---", "2");
		morseCode.put("...--", "3");
		morseCode.put("....-", "4");
		morseCode.put(".....", "5");
		morseCode.put("-....", "6");
		morseCode.put("--...", "7");
		morseCode.put("---..", "8");
		morseCode.put("----.", "9");
	}
}
