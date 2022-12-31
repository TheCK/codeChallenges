package org.ck.codeeval.hard.messageDecoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 36, name = "Message Decoding", description = "Decode an encoded message", url = "https://www.codeeval.com/open_challenges/36/", category = "Hard challenges")
public class Main
{
	private static int READ_LENGTH = 0;
	private static int READ_KEY = 1;

	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = buffer.readLine()) != null)
			{
				line = line.trim();

				int messageBegin = Math.min(line.indexOf("1"), line.indexOf("0"));
				String alphabet = line.substring(0, messageBegin);
				String message = line.substring(messageBegin);

				Map<String, String> mapping = getMapping(alphabet);

				int mode = READ_LENGTH;
				int segmentLength = 0;

				StringBuilder builder = new StringBuilder();
				while (true)
				{
					if (mode == READ_LENGTH)
					{
						String[] newVals = getFromMessage(message, 3, buffer);
						String lengthString = newVals[0];
						message = newVals[1];

						if ("000".equals(lengthString))
						{
							break;
						}

						segmentLength = Integer.parseInt(lengthString, 2);
						mode = READ_KEY;
					}
					else if (mode == READ_KEY)
					{
						String[] newVals = getFromMessage(message, segmentLength, buffer);
						String segment = newVals[0];
						message = newVals[1];

						if (!segment.contains("0"))
						{
							mode = READ_LENGTH;
						}
						else
						{
							builder.append(mapping.get(segment));
						}
					}
				}

				System.out.println(builder);
			}
		}
	}

	private static String[] getFromMessage(String message, int length, BufferedReader buffer) throws IOException
	{
		String currentMessage = message;

		if (currentMessage.length() < length)
		{
			currentMessage += buffer.readLine().trim();
		}
		return new String[] { currentMessage.substring(0, length), currentMessage.substring(length) };
	}

	private static Map<String, String> getMapping(String alphabet)
	{
		Map<String, String> mapping = new HashMap<>();

		String[] keys = getKeys();

		for (int i = 0; i < alphabet.length(); ++i)
		{
			mapping.put(keys[i], alphabet.substring(i, i + 1));
		}

		return mapping;
	}

	private static String[] getKeys()
	{
		List<String> keys = new ArrayList<>();
		
		for (int length = 1; length < 8; ++length)
		{
			for (int value = 0; value < (((int) Math.pow(2, length)) - 1); ++value)
			{
				keys.add(fill(Integer.toBinaryString(value), length));
			}
		}
		
		return keys.toArray(new String[] {});
	}

	private static String fill(String binaryString, int length)
	{
		String newString = binaryString;
		
		while (newString.length() != length)
		{
			newString = "0" + newString;
		}
		
		return newString;
	}
}