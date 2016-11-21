package org.ck.codeEval.medium.meetcombsort;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("2", "3"), this.output.toString());
	}

	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("7", "6", "9", "9", "6", "9", "9", "8", "9", "7",
			"10", "9", "9", "7", "10", "8", "7", "9", "9", "7",
			"8", "7", "3", "8", "9", "11", "6", "9", "7", "10",
			"10", "8", "7", "8", "7", "7", "9", "9", "6", "9"), this.output.toString());
	}
}
