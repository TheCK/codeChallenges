package org.ck.codeEval.medium.lowestCommonAncestor;

import static org.junit.Assert.assertEquals;

import org.ck.codeEval.test.BaseTest;
import org.junit.Test;

public class MainTest extends BaseTest
{
	@Test
	public void test00() throws Exception
	{
		Main.main(getFileAsArgs("00"));

		assertEquals(getResult("30", "8"), this.output.toString());
	}
	
	@Test
	public void test01() throws Exception
	{
		Main.main(getFileAsArgs("01"));

		assertEquals(getResult("8", "8", "30", "8", "20", "8", "8", "8", "30", "8", "30", "20", "20", "20", "30", "8", "30", "30", "8", "8"), this.output.toString());
	}
}
