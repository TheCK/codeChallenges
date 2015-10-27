package org.ck.codeEval.medium.blackorwhite;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("1x1, 1", "2x2, 2", "3x3, 7", "1x1, 0"), this.output.toString());
	}

	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("5x5, 13"), this.output.toString());
	}
}
