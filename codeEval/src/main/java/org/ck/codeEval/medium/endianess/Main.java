package org.ck.codeEval.medium.endianess;

import java.nio.ByteOrder;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		System.out.println(ByteOrder.BIG_ENDIAN.equals(ByteOrder.nativeOrder()) ? "BigEndian" : "LittleEndian");
	}
}