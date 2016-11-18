package org.ck.codeEval.easy.mersenneprime;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("3", "3, 7, 31, 127"), this.output.toString());
	}

	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("3, 7, 31, 127",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127",
			"3, 7, 31, 127, 2047",
			"3",
			"3, 7, 31, 127",
			"3, 7, 31, 127, 2047",
			"3, 7, 31, 127",
			"3, 7, 31",
			"3, 7, 31, 127",
			"3, 7, 31, 127",
			"3, 7, 31, 127",
			"3, 7, 31, 127, 2047"), this.output.toString());
	}
}
