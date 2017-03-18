package org.ck.hackerRank.corecs.algorithms.strings.caesarcipher;

import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 10304,
		name = "Caesar Cipher",
		url = "https://www.hackerrank.com/challenges/caesar-cipher-1",
		category = "Algorithms",
		subCategory = "Strings"
)
public class Solution
{
	public static void main(String[] args)
	{
		try (Scanner in = new Scanner(System.in))
		{
			in.nextInt();
			String string = in.next();
			int amount = in.nextInt() % 26;

			String cipher = string
					.chars()
					.map(character ->
					{
						if (character >= 65 && character <= 90)
						{
							character += amount;

							if (character > 90)
							{
								character -= 26;
							}
						}

						if (character >= 97 && character <= 122)
						{
							character += amount;

							if (character > 122)
							{
								character -= 26;
							}
						}

						return character;
					})
					.mapToObj(character -> String.valueOf((char) character))
					.collect(Collectors.joining());

			System.out.println(cipher);
		}
	}
}