package org.ck.codeeval.medium.endianess;

import java.nio.ByteOrder;

import org.ck.codechallengelib.annotation.Solution;

@Solution(id = 15, name = "Endianness", description = "Determine the endianness of a system.", url = "https://www.codeeval.com/open_challenges/15/", category = "Moderate challenges")
public class Main
{
	public static void main(String[] args) throws Exception
	{
		System.out.println(ByteOrder.BIG_ENDIAN.equals(ByteOrder.nativeOrder()) ? "BigEndian" : "LittleEndian");
	}
}