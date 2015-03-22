package org.ck.codeEval.medium.uriComparison;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("True"), this.output.toString());
	}
	
	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("True",
				"False",
				"True",
				"True",
				"False",
				"True",
				"True",
				"True",
				"False",
				"True",
				"True",
				"False",
				"False",
				"True",
				"True",
				"True",
				"False",
				"True",
				"True",
				"False"), this.output.toString());
	}
}
