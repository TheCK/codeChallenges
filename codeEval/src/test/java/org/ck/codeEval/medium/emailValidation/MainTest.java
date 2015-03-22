package org.ck.codeEval.medium.emailValidation;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("true", "false", "false", "true"), this.output.toString());
	}

	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("false",
				"true",
				"true",
				"true",
				"true",
				"false",
				"true",
				"false",
				"false",
				"true",
				"false",
				"false",
				"true", //?????
				"false",
				"true",
				"true",
				"false",
				"false",
				"false",
				"true"), this.output.toString());
	}

	@Test
	public void testCustom00() throws Exception
	{
		Main.main(getFileAsArgs("custom00"));

		assertEquals(getResult("true", "false"), this.output.toString());
	}
}
