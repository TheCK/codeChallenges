package org.ck.codeEval.hard.uglynumers;

import org.ck.codeEval.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("0", "1", "6", "64"), this.output.toString());
	}

	@Test
	@Ignore
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("0", "1", "6", "64"), this.output.toString());
	}
}